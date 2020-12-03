package calculator;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class Number {

    private static final Map<Integer, Number> CHACHE = new WeakHashMap<>();

    private Number(final int value) {
        this.value = value;
    }

    private final int value;

    public static Number valueOf(final String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static Number valueOf(final int value) {
        return CHACHE.computeIfAbsent(value, Number::new);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
