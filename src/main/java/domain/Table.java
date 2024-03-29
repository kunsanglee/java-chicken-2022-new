package domain;


import java.util.Objects;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Table table)) {
            return false;
        }
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
