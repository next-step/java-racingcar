package racingcar.domain;

import java.util.regex.Pattern;

public class RacingGameConstant {
    public static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    public static final String REQUEST_TRY_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static final String IS_NOT_A_NUMBER = "숫자만 입력해 주세요.";
    public static final String IS_NOT_NULL = "공백은 입력할 수 없습니다.";
    public static final String IS_NOT_A_COMMA = "구분자는 쉼표(,)만 입력해 주세요.";
    public static final String NO_WINNER = "우승자를 구할 수 없습니다.";

    public static final String WINNER_COMMENT_PREFIX = "실행 결과\n%s";
    public static final String WINNER_COMMENT_SUFFIX = "가 최종 우승했습니다.";

    public static final String DELIMITER_COMMA = ",";

    public static final String NULL_BLANK = "";
    public static final String COLON = " : ";
    public static final String CAR_MARKER = "-";
    public static final String CARRIAGE_RETURN = "\n";

    public static final int RANDOM_LIMIT = 9;
    public static final int MOVE_CONDITION = 4;

    public static final int START_POSITION = 0;
    public static final int NUMBER_ZERO = 0;
    public static final int NUMBER_ONE = 1;

    public static final Pattern COMMA_PATTERN = Pattern.compile("(?:,|$)");

}

