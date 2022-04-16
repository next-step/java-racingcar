package racingcar.dto;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class InputCars {
    public static final String CAR_DELIMITER = ",";

    private final Cars cars;

    private InputCars(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public Cars value() {
        return cars;
    }

    public static InputCars fromCarsInfo(String carsInfo) {
        validate(carsInfo);
        return getInputCars(carsInfo);
    }

    private static void validate(String carsInfo) {
        Objects.requireNonNull(carsInfo, "InputCars 에 전달된 입력 값이 올바르지 않습니다 : carsInfo is null");
    }

    private static InputCars getInputCars(String carsInfo) {
        String[] carNames = carsInfo.trim().split(CAR_DELIMITER);
        int carsCount = carNames.length;

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            cars.add(new Car(CarName.from(carNames[i].trim())));
        }

        return new InputCars(cars);
    }
}
