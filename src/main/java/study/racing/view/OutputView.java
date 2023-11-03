package study.racing.view;

public class OutputView {

    private static final String CARS_NUMBER_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과\n";

    public void printCarsNumberMessage() {

        System.out.println(CARS_NUMBER_MESSAGE);
    }

    public void printRacingCountMessage() {

        System.out.println(RACING_COUNT_MESSAGE);
    }

    public void printRacingResultMessage(String racingResult) {

        System.out.println(RACING_RESULT_MESSAGE + racingResult);
    }
}
