package racingcar.domain;

import java.util.List;
import java.util.Random;

public class GameBoard {

    private final Cars cars;
    private final Random random;

    GameBoard(List<Car> cars) {
        this(new Cars(cars));
    }

    public GameBoard(Cars cars) {
        this.cars = cars;
        this.random = new Random();
    }

    public void play() {
        cars.move(random);
    }

    public CarNames getWinnerNames() {
        return cars.getWinnerNames();
    }

    public Cars getCars() {
        return this.cars;
    }
}
