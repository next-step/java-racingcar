package racingcar.rule;

public class MinimumRule implements Rule {

    private static final int INITIAL_VALUE = 0;

    private final int min;
    private int value;

    public MinimumRule(int min) {
        this.min = min;
        this.value = INITIAL_VALUE;
    }

    public MinimumRule(int min, int value) {
        this.min = min;
        this.value = value;
    }

    @Override
    public boolean verify() {
        return moreThanMin();
    }

    private boolean moreThanMin() {
        return min <= value;
    }
    
    public void changeValue(int value) {
        this.value = value;
    }
}
