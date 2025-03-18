package racingcar.model;

import racingcar.message.Message;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    List<Car> cars;

    public RacingGame(int carCount) {
        this.cars = CarGenerator.createCars(carCount);
    }

    public void race(int attemptCount) {
        OutputView.print(Message.RESULT_MESSAGE);

        IntStream.range(0, attemptCount)
                .forEach(i -> {
                    moveCars();
                    OutputView.print("");
                });
    }

    private void moveCars() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generateNumber()));
        cars.forEach(Car::printPosition);
    }
}
