package racingcar.rule;

public class MinimumRule implements Rule {
    private final int min;

    public MinimumRule(int min) {
        this.min = min;
    }

    @Override
    public boolean verify(int value) {
        return moreThanMin(value);
    }

    private boolean moreThanMin(int value) {
        return min <= value;
    }
}
