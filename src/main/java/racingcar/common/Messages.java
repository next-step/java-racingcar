package racingcar.common;

public enum Messages {
    INPUT_FOR_NAME_OF_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_FOR_NUMBER_OF_TRIALS("시도할 회수는 몇 회 인가요?"),
    RESULT_START_MESSAGE("실행 결과"),
    RESULT_CAR_SHAPE("-"),
    RESULT_EMPTY_STRING(""),
    RESULT_CAR_STATE_SPERATOR(" : "),
    RESULT_WINNER_STRING("가 최종 우승했습니다."),
    RESULT_WINNER_SEPERATOR(", ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String valueOf() {
        return this.message;
    }
}
