package study.racingcar.domain;

import study.racingcar.strategy.NumberGenerator;
import study.racingcar.strategy.RandomNumberGenerator;

public class Rule {

    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public static final String CAR_SHAPE = "-";
    public static final int MOVABLE_LOWER_BOUND = 4;

    public static NumberGenerator numberGenerator() {
        return numberGenerator;
    }

}
