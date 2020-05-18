package step3;

import java.util.List;

public class ResultView {

    private static List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public static void viewResult() {
        for (Car car : cars) {
            car.printCurrentLocation();
        }
    }

}
