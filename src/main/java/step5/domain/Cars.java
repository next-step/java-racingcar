package step5.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String DEFAULT_RACING_RESULT = "";
    private static final int CAR_POSITIONS_SIZE = 0;

    private List<Car> cars;

    public Cars(String[] splitCarName) {
        validateCars(splitCarName);
        cars = createUsers(splitCarName);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> createUsers(String[] splitCarName) {
        return Arrays.stream(splitCarName)
                     .map(carName -> new Car(carName, DEFAULT_RACING_RESULT))
                     .collect(toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateCars(String[] splitCarName) {
        if (splitCarName.length <= CAR_POSITIONS_SIZE) {
            throw new IllegalArgumentException("자동차의 개수는 최소 1대 이상이어야 합니다.");
        }
    }
}
