package step4.game;

import step3.move.BasicMoveStrategy;
import step4.model.Cars;
import step4.move.MovableStrategy;

public class Game {
    private final int gameCount;
    private final Cars cars;

    public Game(int gameCount, Cars cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public static Game of(int count, Cars cars) {
        return new Game(count, cars);
    }

    public void run(MovableStrategy movableStrategy) {
        for (int i = 0; i < gameCount; i++) {
            cars.move(movableStrategy);
        }
    }

    public int countOfGame() {
        return gameCount;
    }

    public Cars cars() {
        return cars;
    }
}
