package study.step3;

import java.util.List;

public class GameConfig {

    private int gameCount;
    private int carCount;

    public GameConfig(int gameCount, int carCount) {
        this.gameCount = gameCount;
        this.carCount = carCount;
        if (gameCount < 1)
            throw new IllegalArgumentException("게임횟수는 1회 이상이어야 한다");

        if (carCount < 2)
            throw new IllegalArgumentException("자동차는 2대 이상이어야 한다");
    }

    public List<Car> getCars() {
        return null;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
