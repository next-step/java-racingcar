package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final String CAR_NUMBER_FORMAT = "car_number_%d";

    private final List<Car> cars;

    public RacingCars(int carCount) {
        List<Car> preparedCars = prepareCars(carCount);
        this.cars = preparedCars;
    }

    private List<Car> prepareCars(int carCount) {

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
