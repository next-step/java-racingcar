package commons;

import java.util.regex.Pattern;

public class Constant {
    // 자동차 경주
    public static final String NUMBER_OF_CARS_PROMPT = "자동차 대수는 몇 대 인가요?";
    public static final String RACING_TIMES_PROMPT = "시도할 회수는 몇 회 인가요?";
    public static final String NUMERIC_REGEX = "^-?\\d+$";
    public static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    public static final String ZERO_OR_NEGATIVE_NUMERIC_ERR_MSG = "0 또는 음수가 입력되었습니다.";
    public static final String NON_NUMERIC_ERR_MSG = "숫자 이외의 값이 입력되었습니다.";

    public static final int RANDOM_MINIMUM_VALUE_CAN_BE_MOVED = 4;
    public static final int MOVEMENT_DISTANCE_INITIAL_VALUE = 0;
    public static final int RANDOM_NUMBER_BOUND = 10;

    // 문자열 덧셈 계산기
    public static final String BASIC_SPLIT_REGEX = ",|:";
    public static final String NUMBER_RANGE_REGEX = "[0-9]";

    public static final String NEGATIVE_OR_NON_NUMERIC_ERR_MSG = "숫자 이외의 값 또는 음수가 입력되었습니다.";

    public static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");
}
