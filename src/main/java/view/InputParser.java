package view;

import static exception.ExceptionMessage.INPUT_MAIN_MENU_NOT_NUMBER;

public class InputParser {

    public static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MAIN_MENU_NOT_NUMBER.getMessage());
        }
    }
}
