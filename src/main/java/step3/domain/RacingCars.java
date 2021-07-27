package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(GameSetting gameSetting) {
        List<Car> preparedCars = prepareCars(gameSetting);
        this.cars = preparedCars;
    }

    private List<Car> prepareCars(GameSetting gameSetting) {
        List<String> carNames = gameSetting.getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
