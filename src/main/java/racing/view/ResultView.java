package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;

public final class ResultView {

    private static final String RACING_RESULT = "실행 결과";

    private static final String DISPLACEMENT_SYMBOL = "-";

    private ResultView() {}

    public static void viewMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void viewRoundResult(final RacingCars racingCars) {
        for (final Car car : racingCars.getCars()) {
            System.out.println(repeat(car.getDisplacement()));
        }

        System.out.println();
    }

    private static String repeat(int times) {
        return new String(new char[times]).replace("\0", DISPLACEMENT_SYMBOL);
    }
}
