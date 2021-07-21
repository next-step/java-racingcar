package step3.game;

import step3.model.Cars;

public class GameEnv {
    int carCount;
    int count;

    protected GameEnv(int carCount, int count) {
        this.carCount = carCount;
        this.count = count;
    }

    static public GameEnv of(int carCount, int count) {
        return new GameEnv(carCount, count);
    }

    public Game createGame() {
        return Game.of(count, Cars.of(carCount));
    }
}
