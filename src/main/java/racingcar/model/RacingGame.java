package racingcar.model;

import racingcar.message.Message;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(int carCount) {
        this.cars = CarGenerator.createCars(carCount);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public RacingGame race(int attemptCount) {
        OutputView.print(Message.RESULT_MESSAGE);

        List<Car> updatedCars = cars;
        for (int i = 0; i < attemptCount; i++) {
            updatedCars = moveCars(updatedCars);
            OutputView.print("");
        }

        return new RacingGame(updatedCars);
    }

    private List<Car> moveCars(List<Car> currentCars) {
        List<Car> movedCars = currentCars.stream()
                .map(car -> car.move(RandomNumberGenerator.generateNumber()))
                .collect(Collectors.toList());

        movedCars.forEach(Car::printPosition);

        return movedCars;
    }
}
