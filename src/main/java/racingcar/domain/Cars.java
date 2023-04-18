package racingcar.domain;

import racingcar.dto.CarResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String NOT_FOUND_POSITION = "최고 포지션을 찾을 수 없습니다.";
    private static final String MIN_LENGTH_FORNAT = "자동차는 %s개 이상이여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;

    private List<Car> cars = new ArrayList<>();

    public Cars(final String carNames, final RandomNumberGenerator randomNumberGenerator) {
        generate(split(carNames), randomNumberGenerator);
    }

    private String[] split(final String carNames) {
        return carNames.split(DELIMITER);
    }

    private void generate(final String[] carNames, final RandomNumberGenerator randomNumberGenerator) {
        validate(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName, randomNumberGenerator));
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

    public List<CarResult> winners() {
        Car winner = findWinner();
        return this.cars
                .stream()
                .filter(car -> car.isWinner(winner))
                .map(CarResult::new)
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        return this.cars
                .stream()
                .max(Car::comparePosition)
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_POSITION));
    }

    public List<Car> getCars() {
        return cars;
    }
}
