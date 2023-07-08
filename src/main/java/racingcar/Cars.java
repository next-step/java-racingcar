package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String INVALID_CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름이 유효하지 않습니다";

    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;
    private final List<Car> cars;

    public Cars(String rawCarNames) {
        List<String> carNames = parseCarNames(rawCarNames);

        validateCarNames(carNames);

        this.cars = generateCars(carNames);
    }

    public Cars(Car... cars) {
        this.cars = Arrays.stream(cars).collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            car.move(generateRandom());
        }
    }

    private int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }


    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public String[] getWinners() {
        int maxPosition = maxPosition();

        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public List<String> getResult() {
        return cars.stream()
                .map(Car::statusToString)
                .collect(Collectors.toList());
    }

    private List<String> parseCarNames(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        checkEmpty(carNames);
        validateCarNamesLength(carNames);
    }

    private void checkEmpty(List<String> carNames) {
        if (carNames.size() == 0) {
            throw new RuntimeException(INVALID_CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    private void validateCarNamesLength(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
            throw new RuntimeException(INVALID_CAR_NAME_EXCEPTION_MESSAGE);
        }
    }
}
