package racingcarGame.dto;

import racingcarGame.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameData {
    private static final int RANDOM_BASE_VALUE = 4;

    private final List<Car> cars;
    private final int playCount;

    public GameData(int playerCount, int playCount) {
        this.cars = new ArrayList<>();
        this.playCount = playCount;

        for (int i = 0; i < playerCount; i++) {
            cars.add(new Car(""));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameData gameData = (GameData) o;
        return playCount == gameData.playCount &&
                Objects.equals(cars, gameData.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, playCount);
    }
}
