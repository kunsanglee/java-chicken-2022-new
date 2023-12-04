package view;

import static exception.ExceptionMessage.INPUT_MAIN_MENU_NOT_NUMBER;
import static exception.ExceptionMessage.NOT_FOUND_INPUT_MAIN_MENU;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainMenu inputMenuNumber() {
        try {
            int inputNumber = Integer.parseInt(String.valueOf(scanner.nextInt()));
            return Arrays.stream(MainMenu.values())
                    .filter(mainMenu -> mainMenu.getNumber() == inputNumber)
                    .findAny().orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_INPUT_MAIN_MENU.getMessage()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MAIN_MENU_NOT_NUMBER.getMessage());
        }
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
