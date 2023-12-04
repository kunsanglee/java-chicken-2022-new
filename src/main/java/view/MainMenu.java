package view;

public enum MainMenu {
    REGISTER_ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");;

    private final int number;
    private final String menuName;

    MainMenu(int number, String menuName) {
        this.number = number;
        this.menuName = menuName;
    }

    public int getNumber() {
        return number;
    }

    public String getMenuName() {
        return menuName;
    }

    public boolean isContinue() {
        return !this.equals(MainMenu.EXIT);
    }
}
