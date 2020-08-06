package racingcar.constant;

public final class RacingMessage {
    public static final String INPUT_CAR_LIST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_ROUND = "시도할 회수는 몇 회 인가요?";
    public static final String WINNER_MESSAGE_FORMAT = "%s 가 최종 우승했습니다.";

    public static final String NOT_FOUND_FIRST_POSITION_CAR = "선두에 위치한 차를 찾을 수 없습니다.";
    public static final String VALID_NAME_LENGTH = "이름은 1자 이상 5자 이하로 입력하세요.";
    public static final String DUPLICATED_NAME = "중복된 이름이 존재합니다.";

    private RacingMessage() {}
}
