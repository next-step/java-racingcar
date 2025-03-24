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
        if (numberOfCars <= 1) {
            throw new IllegalArgumentException("자동차 대수는 2 이상이어야 합니다.");
        }
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
        this.numberOfRounds = numberOfRounds;
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
        this.movingStrategy = movingStrategy;
    }

    public List<Car> getCars() {
        return cars;
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

}
