package car;

import java.util.List;

public class ResultView {
    private static String CAR_DISTANCE_BAR = "-";
    public static void outputGameResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(makeCarDistanceOutput(car.getDistance()));
        }
    }

    private static String makeCarDistanceOutput(Integer distance) {
        return CAR_DISTANCE_BAR.repeat(distance);
    }
}
