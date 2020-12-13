package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE_NO = 10;
    private static final int MOVABLE_CONDITION = 4;
    private static final int MIN_CONDITION = 0;
    private static final int MAX_CONDITION = 9;
    private static final String OUT_OF_RANGE_CONDITION = "전진 조건 범위를 초과하였습니다.";


    private final Random RANDOM = new Random();

    public boolean movable() {
        validateMoveCondition(getRandomRangeNo());
        return getRandomRangeNo() >= MOVABLE_CONDITION;
    }

    private void validateMoveCondition(int condition) {
        if (condition < MIN_CONDITION || condition > MAX_CONDITION) {
            throw new IllegalArgumentException(OUT_OF_RANGE_CONDITION);
        }
    }

    public int getRandomRangeNo() {
        return RANDOM.nextInt(RANDOM_RANGE_NO);
    }
}
