package carracing.domain;

import java.util.HashMap;
import java.util.Map;

public class RandomNumber {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "랜덤 값이 유효하지 않습니다. randomNumber: %d";
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 9;

    private static final Map<Integer, RandomNumber> cache = new HashMap<>();

    private final int number;

    private RandomNumber(int number) {
        this.number = number;
        cache.put(number, this);
    }

    public static RandomNumber of(int number) {
        validateNumberRange(number);
        return cache.containsKey(number) ? cache.get(number) : new RandomNumber(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOWER_LIMIT || number > UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, number));
        }
    }

    public boolean isOver(int number) {
        return this.number > number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandomNumber)) return false;
        RandomNumber that = (RandomNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
