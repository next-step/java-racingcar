package study.racingcar.rule;

import study.racingcar.strategy.NumberGenerator;
import study.racingcar.strategy.RandomNumberGenerator;

public class DomainRule {

    private final NumberGenerator numberGenerator;
    public static final int MOVABLE_LOWER_BOUND = 4;

    public DomainRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public int generate() {
        return numberGenerator.generate();
    }

    public DomainRule() {
        this.numberGenerator = new RandomNumberGenerator();
    }

}
