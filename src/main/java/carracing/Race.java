package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int numberOfRounds;
    private final MovingStrategy movingStrategy;

    public Race(List<Car> cars, int numberOfRounds, MovingStrategy movingStrategy) {
        validateRaceConditions(cars.size(), numberOfRounds);
        this.numberOfRounds = numberOfRounds;
        this.cars = cars;
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

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == cars.stream().mapToInt(Car::getPosition).max().orElse(0))
                .collect(Collectors.toList());
    }

}
