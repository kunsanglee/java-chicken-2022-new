package domain;

import static exception.ExceptionMessage.INVALID_ORDER_QUANTITY;
import static exception.ExceptionMessage.ORDER_SAME_MENU_COUNT_EXCEED;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void add(Table table, Menu orderMenu, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(INVALID_ORDER_QUANTITY.getMessage());
        }
        if (isExceedOrderQuantity(table, orderMenu, quantity)) {
            throw new IllegalArgumentException(ORDER_SAME_MENU_COUNT_EXCEED.getMessage());
        }
        orders.add(new Order(table, orderMenu, quantity));
    }

    public static boolean isExceedOrderQuantity(Table table, Menu menu, int quantity) {
        List<Order> tableOrders = getTableOrders(table);
        int orderedQuantity = getOrderMenuQuantity(menu, tableOrders);
        return orderedQuantity + quantity >= 100;
    }

    private static int getOrderMenuQuantity(Menu menu, List<Order> tableOrders) {
        return tableOrders.stream()
                .filter(order -> order.isSameMenu(menu))
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public static double getTableTotalPrice(Table table) {
        List<Order> tableOrders = getTableOrders(table);
        int totalPrice = sumOrderPrice(tableOrders);
        return totalPrice - getChickenDiscount(tableOrders);
    }

    public static List<Order> getTableOrders(Table table) {
        return orders.stream()
                .filter(order -> order.isSameTable(table))
                .collect(Collectors.toList());
    }

    public static Map<Menu, Integer> getTableOrderMenu(Table table) {
        return getTableOrders(table).stream()
                .collect(Collectors.groupingBy(Order::getMenu, Collectors.summingInt(Order::getQuantity)));
    }

    private static int sumOrderPrice(List<Order> tableOrders) {
        int sum = 0;
        for (Order order : tableOrders) {
            sum += order.getTotalPrice();
        }
        return sum;
    }

    private static int getChickenDiscount(List<Order> tableOrders) {
        return (int) (getChickenCount(tableOrders) / 10) * 10_000;
    }

    private static long getChickenCount(List<Order> tableOrders) {
        return tableOrders.stream()
                .filter(Order::isChicken)
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public static boolean isOrderedTable(Table table) {
        return orders.stream()
                .anyMatch(order -> order.isSameTable(table));
    }

//    public static void pay(Table table) {
//        orders.stream().filter(order -> order.isSameTable(table)).forEach(orders::remove);
//    }
}
