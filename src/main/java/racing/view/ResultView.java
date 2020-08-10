package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RACING_END_MESSAGE = "실행 결과";
    private static final String DISPLAY_MOVEMENT = "-";

    private ResultView() {
    }

    public static void printRacingGameResult() {
        System.out.println(RACING_END_MESSAGE);
    }

    public static void printLocationsByCars(final List<Car> cars) {
        for (final Car car : cars) {
            System.out.println(printLocationByCar(car));
        }
        System.out.println();
    }

    public static String printLocationByCar(final Car car) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getLocation(); i++) {
            stringBuilder.append(DISPLAY_MOVEMENT);
        }
        return stringBuilder.toString();
    }
}
