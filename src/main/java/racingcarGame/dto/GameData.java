package racingcarGame.dto;

import racingcarGame.Car;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private static final int RANDOM_BASE_VALUE = 4;

    private final List<Car> cars;
    private final int playCount;

    public GameData(int playerCount, int playCount) {
        this.cars = new ArrayList<>();
        this.playCount = playCount;

        for (int i = 0; i < playerCount; i++) {
            cars.add(new Car(0, ""));
        }
    }

    public static int getRandomBaseValue() {
        return RANDOM_BASE_VALUE;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getPlayCount() {
        return playCount;
    }
}
