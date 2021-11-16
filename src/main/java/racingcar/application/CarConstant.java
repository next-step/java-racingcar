package racingcar.application;

public class CarConstant {
    //String
    public static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_CAR_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String OUTPUT_CAR_WINNER_MESSAGE = "가 최종 우승헀습니다.";

    //int
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final int CAR_DEFAULT_STATE = 0;

    //EXCEPTION
    public static final String EXCEPTION_CAR_NAME_LIMIT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    public static final String EXCEPTION_CAR_NAME_IS_EMPTY_OR_NULL = "자동차 이름이 비어있거나 NULL 입니다.";

}
