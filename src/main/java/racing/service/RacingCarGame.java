package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public static void startRacing(List<Car> cars, int round) {
        for (int i = 0; i < round; i++) {
            startRound(cars);

            System.out.println();
        }
    }

    public static void startRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");

            int moveDistance = car.move();

            RacingCarView.viewCarMoveInfo(moveDistance);

            System.out.println();
        }
    }
}
