package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public class RaceViewService {
    public static final String MOVE_SYMBOL = "-";

    public static void printCars(List<Car> cars) {
        cars.forEach(RaceViewService::printCarDistance);
    }

    public static void printCarDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }
}
