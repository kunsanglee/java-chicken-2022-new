package domain;

import static exception.ExceptionMessage.NOT_FOUND_PAYMENT;

import java.util.Arrays;

public enum Payment {
    CARD(1, "카드"),
    CASH(2, "현금"),
    ;

    private final int number;
    private final String name;

    public static Payment of(int number) {
        return Arrays.stream(values()).filter(payment -> payment.number == number).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_PAYMENT.getMessage()));
    }

    Payment(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
