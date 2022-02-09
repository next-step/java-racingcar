package racinggame.exception;

public class ExceptionBaseMessage {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String LACK_OF_PLAYER_MESSAGE = String.format(
            "게임을 시작하려면 %d명 이상의 참가자가 필요합니다.", MINIMUM_PLAYER);
    public static final String INPUT_BLANK_MESSAGE = "값이 입력되지 않았습니다.";
    public static final String NAME_LENGTH_OVER_MESSAGE = String.format("자동차 이름의 글자 수는 %d자 이하입니다.",
            MAXIMUM_NAME_LENGTH);
    public static final String EXCEEDED_RETRIES_EXCEPTION_MESSAGE = "최대 시도 횟수를 초과하였습니다. 게임을 다시 실행합니다.";
    public static final String NOT_A_NUMBER_EXCEPTION_MESSAGE = "시도횟수는 숫자로 입력해주세요.";
}
