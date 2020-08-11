package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.List;

public class ResultView {
    private static final String RACING_END_MESSAGE = "실행 결과";
    private static final String DISPLAY_MOVEMENT = "-";
    private static final String SEPARATOR = ",";
    private static final String NAME_SEPARATOR = " : ";
    private static final String RESULT_RACING_WINNERS_MESSAGE = "%s가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printRacingGameResult() {
        System.out.println(RACING_END_MESSAGE);
    }

    public static void printLocationsByCars(final List<Car> cars) {
        for (final Car car : cars) {
            System.out.println(car.getName() + NAME_SEPARATOR + printLocationByCar(car));
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

    public static void printRacingWinners(final RacingCars racingCars) {
        final String winners = String.join(SEPARATOR, racingCars.getWinners());
        System.out.println(String.format(RESULT_RACING_WINNERS_MESSAGE, winners));
    }
}
