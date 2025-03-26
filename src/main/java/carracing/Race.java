package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int numberOfRounds;
    private final MovingStrategy movingStrategy;

    public Race(int numberOfCars, int numberOfRounds, MovingStrategy movingStrategy) {
        validateRaceConditions(numberOfCars, numberOfRounds);
        this.numberOfRounds = numberOfRounds;
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
        this.movingStrategy = movingStrategy;
    }

    public Race(String[] carNames, int numberOfRounds, MovingStrategy movingStrategy) {
        validateRaceConditions(carNames.length, numberOfRounds);
        this.numberOfRounds = numberOfRounds;
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
        this.movingStrategy = movingStrategy;
    }

    private void validateRaceConditions(int numberOfCars, int numberOfRounds) {
        if (numberOfCars <= 1) {
            throw new IllegalArgumentException("자동차 대수는 2 이상이어야 합니다.");
        }
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public void playRound() {
        cars.forEach(car -> car.move(movingStrategy.canMove()));
    }

    public void playGame(ResultView resultView) {
        for (int i = 0; i < numberOfRounds; i++) {
            playRound();
            resultView.printResult(cars);
            resultView.printRoundSeparator();
        }
    }

    public void getWinners(ResultView resultView) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == cars.stream().mapToInt(Car::getPosition).max().orElse(0))
                .collect(Collectors.toList());
        resultView.printWinners(winners);
    }

}
