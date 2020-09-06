package racingcar.domain.game.utils;

public final class Constants {

    /** Strategy **/
    public static final int INIT_POSITION = 0;

    public static final int ONE_FORWARD = 1;
    public static final int FORWARD_OK_COND_NUM = 4;
    public static final int RANDOM_BOUND = 10;

    /** Exception Message **/
    public static final String ERROR_NULL_OR_BLANK = "은 아무것도 입력하지 않았습니다";
    public static final String ERROR_NAME_LENGTH_OVER = "은 자동차 이름 글자수를 초과했습니다";
    public static final String ERROR_ZERO_OR_NEGATIVE = "은 0 또는 음수입니다";

    /** Utils **/
    public static final int NAME_LENGTH_MAX = 5;
    public static final int VALID_MIN_NUMBER = 1;

    /** UI View **/
    public static final String INPUT_DELIMITER = ",";
    public static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_RACING_COUNT = "시도할 회수는 몇회인가요?";
    public static final String SAY_VIEW_RESULT = "실행 결과";
    public static final String PRINT_GO = "-";
    public static final String PRINT_FORMAT = "%s : %s";
    public static final String WINNER_CAR_NAMES_DELIMITER = ", ";
    public static final String SAY_WINNER_CARS_NAMES = "가 최종 우승했습니다."; //pobi, honux가 최종 우승했습니다.

}
