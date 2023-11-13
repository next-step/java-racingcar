package study.racing.view;

public class OutputView {

    private static final String START_GAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과\n";

    public void printCarsNumberMessage() {

        System.out.println(START_GAME_MESSAGE);
    }

    public void printRacingCountMessage() {

        System.out.println(RACING_COUNT_MESSAGE);
    }

    public void printRacingResultMessage(String racingResult) {

        System.out.println(RACING_RESULT_MESSAGE + racingResult);
    }

    public void printWinner(String winners) {

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
