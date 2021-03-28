package step03Refactor;

public class Config {
    private Config() {}

    static final String MOVE_RANGE = "-";
    static final String DELIMITER = " : ";
    static final String CAR_DELIMITER = ",";

    static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    static final String ERROR_EMPTY_NAME = "이름은 비어있을 수 없습니다.";
    static final String ERROR_NAME_LENGTH = "이름은 5글자 이상 초과할 수 없습니다";
    static final String ERROR_INPUT_ZERO = "입력값은 0 이상이어야 합니다.";
    static final String ERROR_INPUT_CAR_NAME_LENGTH = "차 이름은 0글자 이상 5글자 이하로 입력해주세요.";
    static final String ERROR_CAR_LISt_EMPTY = "참가한 자동차 리스트가 비었습니다.";

    static final String WINNER_SUFFIX = "가 최종 우승했습니다.";



}
