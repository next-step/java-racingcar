package ThirdStep.domain.model;

import ThirdStep.domain.model.request.SettingRequest;

import java.util.List;
import java.util.stream.Collectors;

public class GameSetting {
    private int attempts;
    private final List<Car> cars;

    public GameSetting(SettingRequest settingRequest) {
        this.attempts = settingRequest.getAttempts();
        this.cars = settingRequest.getCarRequests().stream().map(Car::new).collect(Collectors.toList());
    }

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
