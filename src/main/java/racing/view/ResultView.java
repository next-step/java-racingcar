package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class ResultView {
    private static final String PRINT_CAR_FORMAT = "%s\t:\t%s\n";

    public static void printGameStart() {
        System.out.println("실행 결과");
    }

    public static void printCars(Cars cars) {
        for (Car car : cars.deepCopyCarList()) {
            System.out.printf(PRINT_CAR_FORMAT, car.name(), "-".repeat(car.position()));
        }
        System.out.println();
    }
}
