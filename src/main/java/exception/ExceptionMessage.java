package exception;

public enum ExceptionMessage {
    INPUT_MAIN_MENU_NOT_NUMBER("메인 메뉴는 숫자만 입력 가능합니다."),
    NOT_FOUND_INPUT_MAIN_MENU("1,2,3 메인메뉴 중에서 선택해주세요."),
    ;


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
