package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameConfig {

    private int gameCount;
    private int carCount;
    private List<Car> cars = new ArrayList<>();

    public GameConfig(int gameCount, int carCount) {
        if (gameCount < 1)
            throw new IllegalArgumentException("게임횟수는 1회 이상이어야 한다");

        if (carCount < 2)
            throw new IllegalArgumentException("자동차는 2대 이상이어야 한다");

        this.gameCount = gameCount;
        this.carCount = carCount;
        IntStream.range(0, carCount)
                .forEach(i -> cars.add(new Car()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
