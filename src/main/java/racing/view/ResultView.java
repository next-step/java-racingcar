package racing.view;

import java.util.List;
import racing.domain.Car;

public class ResultView {

    private static final String DISTANCE_CHAR = "-";

    public ResultView() {
    }

    public static void printRacingRoundResult(List<Car> cars) {
        cars.forEach(
            car -> System.out.println(printCarRoundResult(car.getName(), car.getDistance())));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 우승했습니다.");
    }

    private static String printCarRoundResult(String name, int distance) {
        String distanceDisplay = "";
        for (int i = 0; i < distance; i++) {
            distanceDisplay += DISTANCE_CHAR;
        }
        return name + " : " + distanceDisplay;
    }
}
