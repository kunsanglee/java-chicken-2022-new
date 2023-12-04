package domain;

public class OrderMenus {
    private final Menu menu;
    private final int quantity;

    public OrderMenus(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean isSameMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    public int calculatePrice() {
        return this.menu.calculatePrice(this.quantity);
    }

    public boolean isChicken() {
        return this.menu.isChicken();
    }

    public int getQuantity() {
        return this.quantity;
    }
}
