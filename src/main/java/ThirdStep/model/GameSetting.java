package ThirdStep.model;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {
    private int attempts;
    private List<Car> cars;

    public GameSetting() {
        cars = new ArrayList<>();
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCars() {
        return cars;
    }
}
