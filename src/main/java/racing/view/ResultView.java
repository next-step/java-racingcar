package racing.view;

import racing.domain.Cars;

public class ResultView {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_TITLE_MESSAGE = "최종 우승: ";

    public static void printRacingResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public static void printCarsPosition(String status) {
        System.out.println(status);
    }

    public static void printWinnerCars(Cars winnerCars) {
        System.out.println(WINNER_TITLE_MESSAGE + String.join(", ", winnerCars.getCarNames()));
    }
}
