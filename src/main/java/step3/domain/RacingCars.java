package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    public static final String CAR_NUMBER_FORMAT = "car_number_%d";

    private final List<Car> cars;

    public RacingCars(GameSetting gameSetting) {
        List<Car> preparedCars = prepareCars(gameSetting);
        this.cars = preparedCars;
    }

    private List<Car> prepareCars(GameSetting gameSetting) {
        int carCount = gameSetting.getCarCount();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            String carNumber = String.format(CAR_NUMBER_FORMAT, i);
            cars.add(new Car(carNumber));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
