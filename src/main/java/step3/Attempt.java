package step3;

import java.util.Objects;

public class Attempt {
    private static final int END = 0;
    private final int number;

    public Attempt(int number) {
        if (number < END) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Attempt make() {
        return new Attempt(this.number - 1);
    }

    boolean isEnd() {
        return number == END;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attempt attempt = (Attempt) o;
        return number == attempt.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
