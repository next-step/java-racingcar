package racing.view;

import java.util.List;

import racing.domain.Car;
import racing.domain.RacingCars;

public final class ResultView {

    private static final String RACING_RESULT = "실행 결과";

    private static final String DISPLACEMENT_SYMBOL = "-";

    public static final String DELIMITER = " : ";

    public static final String WIN_MESSAGE = "가 최종 우승했습니다";

    private ResultView() {}

    public static void viewMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void viewRoundResult(final RacingCars racingCars) {
        for (final Car car : racingCars.getCars()) {
            System.out.println(car.getName() + DELIMITER + repeat(car.getDisplacement()));
        }

        System.out.println();
    }

    public static void viewWinner(final RacingCars racingCars) {
        List<String> winners = racingCars.getWinners();

        System.out.println(winners.toString() + WIN_MESSAGE);
    }

    private static String repeat(int times) {
        return new String(new char[times]).replace("\0", DISPLACEMENT_SYMBOL);
    }
}
