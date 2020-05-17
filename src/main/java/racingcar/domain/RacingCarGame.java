package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;
    private final int moveCount;

    public RacingCarGame(int carCount, int moveCount) {
        this.cars = createCars(carCount);
        this.moveCount = moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(int carCount) {
        cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public void execute(Strategy strategy) {
        for (int i = 0; i < moveCount; i++) {
            GameResult result = carRacing(strategy);
            result.displayResult();
        }
    }

    private GameResult carRacing(Strategy strategy) {
        cars.forEach(car -> {
            int randomNumber = strategy.getNumber();
            car.move(randomNumber);
        });

        return new GameResult(cars);
    }
}

