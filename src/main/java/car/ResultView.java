package car;

import java.util.List;

public class ResultView {
    private static final String CAR_DISTANCE_BAR = "-";

    public static void outputGameResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(makeCarDistanceOutput(car.getDistance()));
        }
    }

    private static String makeCarDistanceOutput(Integer distance) {
        return CAR_DISTANCE_BAR.repeat(distance);
    }
}
