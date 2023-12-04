package exception;

public enum ExceptionMessage {
    INPUT_MAIN_MENU_NOT_NUMBER("메인 메뉴는 숫자만 입력 가능합니다."),
    NOT_FOUND_INPUT_MAIN_MENU("1,2,3 메인메뉴 중에서 선택해주세요."),
    NOT_FOUND_TABLE("존재하지 않는 테이블입니다."),
    NOT_FOUND_MENU("존재하지 않는 메뉴입니다."),
    INVALID_ORDER_QUANTITY("주문 수량은 1개 이상이어야 합니다."),
    ORDER_SAME_MENU_COUNT_EXCEED("주문 수량이 초과되었습니다."),
    NOT_FOUND_ORDER("주문 내역이 없습니다."),
    NOT_FOUND_PAYMENT("잘못된 결제수단 입니다."),
    ;


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
