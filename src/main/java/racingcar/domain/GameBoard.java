package racingcar.domain;

import racingcar.domain.CarName;
import racingcar.domain.Cars;

import java.util.List;

public class GameBoard {

    private final Cars cars;

    public GameBoard(List<CarName> carNames) {
        cars = new Cars(carNames);
    }

    public void run() {
        cars.move();
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNames();
    }

    public Cars getCars() {
        return cars;
    }
}
