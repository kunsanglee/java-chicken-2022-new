package view;

import static exception.ExceptionMessage.NOT_FOUND_INPUT_MAIN_MENU;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainMenu inputMenuNumber() {
        int inputNumber = InputParser.parseInput(scanner.nextLine());
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.getNumber() == inputNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_INPUT_MAIN_MENU.getMessage()));
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return InputParser.parseInput(scanner.nextLine());
    }

    public static int inputOrderMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return InputParser.parseInput(scanner.nextLine());
    }

    public static int inputOrderMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return InputParser.parseInput(scanner.nextLine());
    }

    public static int inputPayment() {
        System.out.println("## 1번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return InputParser.parseInput(scanner.nextLine());
    }
}
