package racingcar.racing;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.CarFactory.initCars;
import static racingcar.utils.RandomValueGenerator.randomForward;
import static racingcar.utils.ValidateUtils.validateCarsName;
import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.resultView;

public class Racing {
    public static void racingStart(String carsName, int tryCount) {
        String[] carsArray = validateCarsName(carsName);
        List<Car> cars = initCars(carsArray);
        for(int i=0; i < tryCount; i++) {
            cars = moveCarForward(cars);
            printCarStatus(cars);
            System.out.println();
        }
        resultView(cars);
    }

    public static List<Car> moveCarForward(List<Car> cars) {
        return cars.stream().peek(car -> car.move(randomForward())).collect(Collectors.toList());
    }
}
