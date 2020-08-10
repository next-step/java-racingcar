package racingcar.racing;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.resultView;

public class Racing {
    public static void racingStart(int carCount, int tryCount) {
        List<Car> cars = initCars(carCount);
        resultView(cars, tryCount);
    }

    public static List<Car> initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public static List<Car> moveCarForward(List<Car> cars) {
        return cars.stream().peek(Car::move).collect(Collectors.toList());
    }
}
