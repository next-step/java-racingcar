package game.service;

import game.domain.Car;
import game.util.NumberGenerator;
import game.util.RandomNumberGenerator;
import game.view.ResultView;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class CarRacing {

    private final List<Car> cars;
    private final int racingRep;

    public CarRacing(List<String> carNames, int racingRep) {
        throwIfNegativeNumber(racingRep);
        this.cars = initialCars(carNames);
        this.racingRep = racingRep;
    }

    private void throwIfNegativeNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    private List<Car> initialCars(List<String> carNames) {
        NumberGenerator generator = new RandomNumberGenerator();
        return carNames.stream()
                .map(name -> new Car(name, generator))
                .collect(toUnmodifiableList());
    }

    public void start() {
        ResultView.displayExecuteResultMessage();
        startRacing();
        ResultView.displayCarWinners(findWinners());
    }

    private void startRacing() {
        for (int rep = 0; rep < racingRep; rep++) {
            cars.forEach(Car::drive);
            ResultView.displayCarPositions(cars);
        }
    }

    private List<Car> findWinners() {
        int max = cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(IllegalStateException::new);
        return cars.stream()
                .filter(car -> car.position() == max)
                .collect(toUnmodifiableList());
    }
}