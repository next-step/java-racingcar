package study.carrace.step3.application.util;

import study.carrace.step3.domain.MoveStrategy;
import study.carrace.step3.domain.RandomIntegerGenerator;
import study.carrace.step3.domain.RandomMoveStrategy;
import study.carrace.step3.domain.RandomZeroAndPositiveIntegerGenerator;

public class MoveStrategyFactory {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_RANDOM_INTEGER = 9;

    private MoveStrategyFactory() {
    }

    public static MoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy(randomIntegerGenerator(), MOVABLE_THRESHOLD);
    }

    private static RandomIntegerGenerator randomIntegerGenerator() {
        return new RandomZeroAndPositiveIntegerGenerator(MAX_RANDOM_INTEGER);
    }
}
