package racing_game.core;

import java.util.Objects;
import racing_game.core.exception.PositiveFormatException;

public class Positive implements Parsable<Positive> {

    private int holder;

    private Positive(String number) {
        parse(number);
    }

    public static Positive of(String number) {
        return new Positive(number);
    }

    public static Positive of(int number) {
        return Positive.of(String.valueOf(number));
    }

    public static Positive zero() {
        return Positive.of(0);
    }

    public static Positive copy(Positive number) {
        if (number == null) {
            number = Positive.zero();
        }
        return Positive.of(number.toInt());
    }

    @Override
    public boolean canParse(String value) {
        return (isNumber(value) && Integer.parseInt(value) >= 0);
    }

    @Override
    public Positive parse(String value) {
        if (!canParse(value)) {
            throw new PositiveFormatException("only positive available");
        }
        this.holder = Integer.parseInt(value);
        return this;
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public Positive add(Positive number) {
        if (number == null) {
            number = Positive.zero();
        }
        this.holder += number.toInt();
        return this;
    }

    public Positive add(Integer number) {
        return add(Positive.of(number));
    }

    public Positive addOne() {
        return add(1);
    }

    public Integer toInt() {
        return this.holder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Number) {
            return Objects.equals(holder, o);
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Positive positive = (Positive) o;
        return holder == positive.holder;
    }

    @Override
    public int hashCode() {
        return holder;
    }
}
