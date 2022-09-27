package ThirdStep.model;

import java.util.List;

public class GameSetting {
    private int attempts;
    private final List<Car> cars;

    public GameSetting(int attempts, List<Car> cars) {
        this.attempts = attempts;
        this.cars = cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void reduceAttempts() {
        attempts = attempts - 1;
    }
}
