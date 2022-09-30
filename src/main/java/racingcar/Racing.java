package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Racing {
    public static void main(String[] args) {
        int numberOfCars = Input.numberOfCars();
        int numberOfAttempts = Input.numberOfAttempts();

        List<Car> cars = Cars.makeCars(numberOfCars);

        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                car.move(RandomGenerator.randomInt());
            }
            for (Car car : cars) {
                Output.resultString(cars);
            }
            Output.resultString(cars);
        }
    }
}
