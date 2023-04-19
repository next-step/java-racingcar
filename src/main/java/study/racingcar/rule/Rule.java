package study.racingcar.rule;

import study.racingcar.strategy.NumberGenerator;
import study.racingcar.strategy.RandomNumberGenerator;

public class Rule {
    /**
     * 게임에 대한 모든 수정 가능한 rule을 관리
     */

    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public static final String CAR_SHAPE = "-";
    public static final int MOVABLE_LOWER_BOUND = 4;

    public static NumberGenerator numberGenerator() {
        return numberGenerator;
    }

}
