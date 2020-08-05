package racingcar.common;

public enum Messages {
    INPUT_FOR_NUMBER_OF_CAR("자동차 대수는 몇 대 인가요?"),
    INPUT_FOR_NUMBER_OF_TRIALS("시도할 회수는 몇 회 인가요?"),
    RESULT_START_MESSAGE("실행 결과"),
    RESULT_CAR_SHAPE("-"),
    RESULT_EMPTY_STRING("");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String valueOf() {
        return this.message;
    }
}
