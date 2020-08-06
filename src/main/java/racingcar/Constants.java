package racingcar;

public final class Constants {

    /** Error Message **/
    public static final String CAR_COUNT_ZERO_OR_BLANK = "자동차 입력 대수가 없거나 0입니다";
    public static final String RACING_COUNT_ZERO_OR_BLANK = "이동 시행 횟수가 없거나 0입니다";
    public static final String CANT_DO_RACE_STRATEGY = "해당 방식으로 이동할 권한이 없습니다";

    /** Strategy **/
    public static final int INIT_POSITION = 0;

    public static final int ONE_FORWARD = 1;
    public static final int ZERO_FORWARD = 0; //Stop이면 또다른 Strategy같음, 여집합의 개념으로 ZERO도입
    public static final int FORWARD_OK_COND_NUM = 4;
    public static final int RANDOM_BOUND = 10;

    /** UI View **/
    public static final String ASK_CAR_COUNTS = "자동차 대수는 몇 대 인가요?";
    public static final String ASK_RACING_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final String SAY_VIEW_RESULT = "\n실행 결과";

    public static final String SAY_FORWARD = "-";
    public static final String SAY_STOP = "";

}
