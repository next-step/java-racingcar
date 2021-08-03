package carracing.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Number {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "랜덤 값이 유효하지 않습니다. randomNumber: %d";
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 9;

    private static final Map<Integer, Number> cache = new ConcurrentHashMap<>();

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validateNumberRange(number);
        cacheIfAbsent(number);
        return cache.get(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOWER_LIMIT || number > UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, number));
        }
    }

    private static void cacheIfAbsent(int number) {
        if (!cache.containsKey(number)) {
            cache.putIfAbsent(number, new Number(number));
        }
    }

    public boolean isOver(int number) {
        return this.number > number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number that = (Number) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
