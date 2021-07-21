package step3.game;

import step3.model.Cars;

import java.util.Random;

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

    public void run() {
        for (int i = 0; i < gameCount; i++) {
            cars.move();
        }
    }

    public int countOfGame() {
        return gameCount;
    }

    public Cars cars() {
        return cars;
    }
}
