package step3.game;

import step3.model.Cars;

public class GameDto {
    int carCount;
    int count;

    protected GameDto(int carCount, int count) {
        this.carCount = carCount;
        this.count = count;
    }

    static public GameDto of(int carCount, int count) {
        return new GameDto(carCount, count);
    }

    public Game createGame() {
        return Game.of(count, Cars.of(carCount));
    }
}
