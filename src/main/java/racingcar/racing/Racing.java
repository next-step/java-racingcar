package racingcar.racing;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.resultView;

public class Racing {
    public static void racingStart(String carsName, int tryCount) {
        String[] carsArray = validateCarsName(carsName);
        List<Car> cars = initCars(carsArray);
        for(int i=0; i < tryCount; i++) {
            cars = moveCarForward(cars);
            printCarStatus(cars);
            out.println();
        }
        resultView(cars);
    }

    public static String[] validateCarsName(String carsName) {
        String[] carsArray = carsName.split(",");
        for(String carName : carsArray) {
            validateCarName(carName);
        }
        return carsArray;
    }

    public static void validateCarName(String carName) {
        if(carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상 5자 이하여야 합니다");
        }
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
