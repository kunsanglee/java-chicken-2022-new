package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int quantity;
    private int totalPrice;

    public Order(Table table, Menu menu, int quantity) {
        this.table = table;
        this.menu = menu;
        this.quantity = quantity;
        this.totalPrice = menu.calculatePrice(quantity);
    }

    public boolean isSameTable(Table table) {
        return this.table.equals(table);
    }

    public boolean isSameMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    public boolean isChicken() {
        return this.menu.isChicken();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public Menu getMenu() {
        return this.menu;
    }
}
