package racingcar.racing;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.resultView;

public class Racing {
    public static void racingStart(String[] carsName, int tryCount) {
        List<Car> cars = initCars(carsName);
        resultView(cars, tryCount);
    }

    public static List<Car> initCars(String[] carsName) {
        List<Car> cars = new ArrayList<>();
        for(String name : carsName) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static List<Car> moveCarForward(List<Car> cars) {
        return cars.stream().peek(Car::move).collect(Collectors.toList());
    }
}
