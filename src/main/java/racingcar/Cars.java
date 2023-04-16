package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {

    private static final String NOT_FOUND_POSITION = "최고 포지션을 찾을 수 없습니다.";
    private static final String MIN_LENGTH_FORNAT = "자동차는 %s개 이상이여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;

    private List<Car> cars = new ArrayList<>();

    public Cars(final String carNames) {
        generate(split(carNames));
    }

    private String[] split(final String carNames) {
        return carNames.split(DELIMITER);
    }

    private void generate(final String[] carNames) {
        validate(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomNumberGenerator()));
        }
    }

    private void validate(final String[] carNames) {
        if (carNames.length < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_LENGTH_FORNAT, MIN_NUMBER));
        }
    }

    public List<CarResult> race() {
        List<CarResult> carResults = new ArrayList<>();
        for (Car car : this.cars) {
            car.racing();
            carResults.add(new CarResult(car));
        }
        return carResults;
    }

    public List<CarResult> winner() {
        return this.cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition())
                .map(CarResult::new)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return this.cars
                .stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_POSITION));
    }

    public List<Car> getCars() {
        return cars;
    }
}
