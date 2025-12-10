package step5.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차 경주를 진행하기 위해서는 두 대 이상의 자동차가 필요합니다.";
    private static final int MIN_CAR_COUNT = 2;

    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this(createCars(carNames.getCarNames()));
    }

    public Cars(List<Car> cars) {
        validateCount(cars.size());
        this.cars = cars;
    }

    private static List<Car> createCars(List<CarName> carNames) {
        List<Car> createdCars = new ArrayList<>();

        for (CarName carName : carNames) {
            createdCars.add(new Car(carName));
        }
        return createdCars;
    }

    private void validateCount(int carCount) {
        if (carCount < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    public int size() {
        return this.cars.size();
    }
}
