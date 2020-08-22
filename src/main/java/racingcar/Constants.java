package racingcar;


import racingcar.domain.Car;
import racingcar.strategy.RaceCondition;

import java.util.ArrayList;
import java.util.List;

public final class Constants {

    public static final String PROTECTED_UTIL_CLASS = "입력 화면은 임의로 생성할 수 없습니다";
    public static final Car EMPTY_CAR = new Car();

    /** Strategy **/
    public static final int INIT_POSITION = 0;

    public static final int ONE_FORWARD = 1;
    public static final int FORWARD_OK_COND_NUM = 4;
    public static final int RANDOM_BOUND = 10;

    /** UI View **/
    public static final String ASK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String ASK_RACING_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final String SAY_VIEW_RESULT = "실행 결과";
    public static final String PRINT_GO = "-";
    public static final String BLANK_LINE = "";

}
