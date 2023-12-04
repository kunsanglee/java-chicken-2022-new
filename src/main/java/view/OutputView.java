package view;

import static exception.ExceptionMessage.NOT_FOUND_ORDER;
import static view.MainMenu.EXIT;
import static view.MainMenu.PAYMENT;
import static view.MainMenu.REGISTER_ORDER;

import domain.Menu;
import domain.Table;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ - ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ # ┘";
    private static final String MAIN_MENU = "%d - %s";
    public static final String ORDER_MENU = "%s %d %d";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenuNumber() {
        System.out.println("## 메인화면");
        System.out.println(String.format(MAIN_MENU, REGISTER_ORDER.getNumber(), REGISTER_ORDER.getMenuName()));
        System.out.println(String.format(MAIN_MENU, PAYMENT.getNumber(), PAYMENT.getMenuName()));
        System.out.println(String.format(MAIN_MENU, EXIT.getNumber(), EXIT.getMenuName()));
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
//            Table table = TableRepository.getTable(index + 1);
//            if (OrderRepository.isOrderedTable(table)) {
//                System.out.println(ORDERED_BOTTOM_LINE);
//            }
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderMenu(Map<Menu, Integer> orderMenu) {
        if (orderMenu.isEmpty()) {
            throw new IllegalArgumentException(NOT_FOUND_ORDER.getMessage());
        }
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        orderMenu.forEach(
                (key, value) -> System.out.println(
                        String.format(ORDER_MENU, key.getName(), value, key.getPrice() * value)));
        System.out.println();
    }

    public static void printTotalPrice(double tableTotalPrice) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(String.format("%d원", (int) tableTotalPrice));
    }
}
