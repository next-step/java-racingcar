package race;

import java.util.List;

public class ResultView {

    protected static void printResult(Cars cars) {
        for (Car car: cars.getCarList()) {
            System.out.println(car.getDistance());
        }
        System.out.println();
    }
}
