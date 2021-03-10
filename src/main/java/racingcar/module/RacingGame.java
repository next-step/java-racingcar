package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars carList) {
        this.cars = carList;
    }

    public int startGame(int tryNum) {
        playCarGame(cars);
        tryNum--;
        if (tryNum == 0) return 0;
        return startGame(tryNum);
    }

    public void playCarGame(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(new RandomStrategy());
        }
    }
}
