package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.List;

public class RacingGame {

    private int turn;

    public RacingGame(int turn) {
        this.turn = turn;
    }

    public List<Car> game(List<Car> cars) {
        for (int i = 0; i < turn; i++) {
            move(cars);
        }

        return cars;
    }

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}

