package car;

import java.util.List;

public class ResultView {
    private static final String CAR_DISTANCE_BAR = "-";
    private static final String CAR_RESULT_JOIN_COLON = " : ";

    public static void outputGameResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(outputCarNameWithDistance(car.getCarName(), makeCarDistance(car.getDistance())));
        }
    }

    private static String outputCarNameWithDistance(String carName, String carDistance) {
        return String.join(CAR_RESULT_JOIN_COLON, carName, carDistance);
    }

    private static String makeCarDistance(Integer distance) {
        return CAR_DISTANCE_BAR.repeat(distance);
    }
}
