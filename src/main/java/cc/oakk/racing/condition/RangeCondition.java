package cc.oakk.racing.condition;

public class RangeCondition implements Condition<Integer> {
    private final int min;
    private final int max;

    public RangeCondition(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("min is larger than a max argument.");
        }

        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isMeetCondition(Integer source) {
        if (source == null) {
            throw new IllegalArgumentException("source is null!");
        }
        return checkNumberRange(source);
    }

    public boolean checkNumberRange(int source) {
        return min <= source && source <= max;
    }
}
