package game.service;

import game.domain.Car;
import game.util.NumberGenerator;
import game.util.RandomNumberGenerator;
import game.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {

    private final List<Car> cars;
    private final int racingRep;

    public CarRacing(int carCount, int racingRep) {
        validateOptions(carCount, racingRep);
        this.cars = initialCars(carCount);
        this.racingRep = racingRep;
    }

    private void validateOptions(int carCount, int racingRep) {
        throwIfNegativeNumber(carCount);
        throwIfNegativeNumber(racingRep);
    }

    private void throwIfNegativeNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    private List<Car> initialCars(int carCount) {
        NumberGenerator generator = new RandomNumberGenerator();
        return IntStream.range(0, carCount)
                .mapToObj(n -> new Car(generator))
                .collect(Collectors.toUnmodifiableList());
    }

    public void start() {
        ResultView.displayExecuteResultMessage();
        startRacing();
    }

    private void startRacing() {
        for (int rep = 0; rep < racingRep; rep++) {
            cars.forEach(Car::drive);
            ResultView.displayGameResult(cars);
        }
    }
}