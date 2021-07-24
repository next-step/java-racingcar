package study.racing.common;

public class Message {
    /*
    * -----------------------
    * Common
    * start|
    * -----------------------
    * RacingController
    * 자동차 대수는 몇대 인가요?
    * 시도할 회수는 몇 회 인가요?
    * 실행결과
    * 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    *------------------------
    *------------------------
    *Validation
    * input Value is null or blank
    * 입력값은 숫자만 허용됩니다.
    * 차량이름은 5자리를 초과할 수 없습니다.
    * -----------------------
    */
    public static final String MSG_RESULT_FORM = "|";
    public static final String MSG_ASK_CARS_COUNT = "자동차 대수는 몇대 인가요?";
    public static final String MSG_ASK_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final String MSG_ROUND_RESULT = "실행 결과";
    public static final String MSG_ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static final String MSG_ERROR_VALUE_NULL_BLANK = "input Value is null or blank";
    public static final String MSG_ERROR_VALUE_TYPE = "입력값은 숫자만 허용됩니다.";
    public static final String MSG_ERROR_VALUE_LIMIT_LENGTH = "차량이름은 5자리를 초과할 수 없습니다.";
}
