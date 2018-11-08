package game.racing.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private Random random;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
        this.random = new Random();
    }

    public GameResult move() {

        for (Car car : cars) {
            int moveNumber = this.random.nextInt(10);
            car.move(moveNumber);
        }

        return new GameResult(cars);
    }

    public GameResult move(int turn) {
        for (int i = 0; i < turn; i++) {
            move();
        }

        return new GameResult(cars);
    }

}
