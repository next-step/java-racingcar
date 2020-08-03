package cc.oakk.racing.predicate;

import java.util.function.Predicate;

public class RangePredicate implements Predicate<Integer> {
    private final int min;
    private final int max;

    public RangePredicate(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("min is larger than a max argument.");
        }

        this.min = min;
        this.max = max;
    }

    @Override
    public boolean test(Integer source) {
        if (source == null) {
            throw new IllegalArgumentException("source is null!");
        }
        return checkNumberRange(source);
    }

    public boolean checkNumberRange(int source) {
        return min <= source && source <= max;
    }
}
