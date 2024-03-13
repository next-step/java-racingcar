package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGameLogic {
    private static RacingCarGameLogic instance = new RacingCarGameLogic();

    private RacingCarGameLogic() {

    }

    public static RacingCarGameLogic getInstance() {
        return instance;
    }

    public void gameLogic(int numberOfCar, int numberOfAttempt) {
        List<Car> cars = initCars(numberOfCar);
        IntStream.range(0, numberOfAttempt).forEach(i -> RacingCarGameRule.getInstance().moveCars(cars));
    }

    private List<Car> initCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>(numberOfCar);
        IntStream.range(0, numberOfCar).forEach(i -> cars.add(new Car()));
        return cars;
    }

}
