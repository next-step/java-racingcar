package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;
    private final int moveCount;

    public RacingCarGame(String carNames, int moveCount) {
        this.cars = createCars(carNames);
        this.moveCount = moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");

        cars = new ArrayList<>();

        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));

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

