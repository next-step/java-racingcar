package step5;

import java.util.Objects;

public class Status {

    private int value;

    public Status(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return value == status1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
