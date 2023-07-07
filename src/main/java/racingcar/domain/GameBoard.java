package racingcar.domain;

import java.util.List;

public class GameBoard {

    private final Cars cars;

    GameBoard(List<Car> cars) {
        this(new Cars(cars));
    }

    public GameBoard(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        cars.move();
    }

    public CarNames getWinnerNames() {
        return cars.getWinnerNames();
    }

    public Cars getCars() {
        return this.cars;
    }
}
