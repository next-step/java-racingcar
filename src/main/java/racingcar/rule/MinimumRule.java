package racingcar.rule;

import racingcar.util.NumberGenerator;

public class MinimumRule implements Rule {
    private final int min;

    private final NumberGenerator numberGenerator;

    public MinimumRule(int min, NumberGenerator numberGenerator) {
        this.min = min;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean verify() {
        return moreThanMin();
    }

    private boolean moreThanMin() {
        return min <= numberGenerator.get();
    }
}
