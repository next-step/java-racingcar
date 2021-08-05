package racingcar.domain.car;

import racingcar.exception.InvalidCarSettingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private static final String INVALID_DUPLICATE_CAR_MESSAGE = "중복된 자동차가 있습니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";

    public Cars(List<String> names) {
        checkCarsValidation(names);
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getCarsMaxPosition() {
        return Collections.max(this.cars).getPosition();
    }

    public List<Car> getWinnerCars(int maxPosition) {
        return cars.stream().filter(c -> c.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private void checkCarsValidation(List<String> names) {
        checkDuplicateCar(names);
        checkCountOfCar(names);
    }

    private void checkDuplicateCar(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new InvalidCarSettingException(INVALID_DUPLICATE_CAR_MESSAGE);
        }
    }

    private void checkCountOfCar(List<String> names) {
        if (names.size() <= 1) {
            throw new InvalidCarSettingException(INVALID_CAR_COUNT_MESSAGE);
        }
    }
}
