package racingcar;



public final class Constants {

    /** Strategy **/
    public static final int INIT_POSITION = 0;

    public static final int ONE_FORWARD = 1;
    public static final int ZERO_FORWARD = 0; //Stop이면 또다른 Strategy같음, 여집합의 개념으로 ZERO도입
    public static final int FORWARD_OK_COND_NUM = 4;
    public static final int RANDOM_BOUND = 10;

    /** UI View **/
    public static final String ASK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String ASK_RACING_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final String SAY_VIEW_RESULT = "실행 결과";

}
