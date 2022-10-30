package racing.domain;

import java.util.ArrayList;
import java.util.List;

import static racing.view.RacingResultView.printResult;

public class Cars {
    public static List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(int carCount) {
        cars = new ArrayList<>();
        for (int i = 1; i <= carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
        return new Cars(cars);
    }

    public static void moveCars() {
        System.out.println();
        for (Car car : cars) {
            car.move();
            printResult(car.getMoveCount());
        }
    }
}
