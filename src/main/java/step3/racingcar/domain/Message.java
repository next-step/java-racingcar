package step3.racingcar.domain;

public class Message {

    public static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String GAME_TRY_COUNTS = "시도할 회수는 몇 회 인가요?";
    public static final String ERROR_CAR_NAMES = "ERROR : 자동차 이름 입력이 잘못되었습니다.";
    public static final String ERROR_GAME_TRY_COUNTS = "ERROR : 입력 숫자는 1 이상이어야 합니다.";
    public static final String ERROR_MAX_POSITION = "ERROR : 우승 차량을 찾을 수 없습니다.";
    public static final String RESULT_HEADER = "실행 결과";
    public static final String RESULT_FOOTER = "가 최종 우승했습니다.";

    private Message() {
    }
}
