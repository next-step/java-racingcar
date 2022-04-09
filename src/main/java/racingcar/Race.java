package racingcar;

public class Race {
    private static final int CHECK_CAR_OR_TRY_COUNT = 0;
    private static final int RANGE_START_RANDOM_NUMBER = 0;
    private static final int RANGE_END_RANDOM_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;

    public static Cars start(int carCount) {
        if (checkCount(carCount)) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        return new Cars(carCount
                , RANGE_START_RANDOM_NUMBER
                , RANGE_END_RANDOM_NUMBER
                , MOVE_CONDITION);
    }

    private static boolean checkCount(int count) {
        return count <= CHECK_CAR_OR_TRY_COUNT;
    }
}
