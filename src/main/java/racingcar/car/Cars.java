package racingcar.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String rawCarNames) {
        String[] carNames = parseCarNames(rawCarNames);
        validateCarNames(carNames);
        this.cars = generateCars(carNames);
    }

    public void move() {
        for (Car car : cars) {
            car.move(generateRandom());
        }
    }

    private int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }

    public String[] getWinners() {
        int winnerCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == winnerCount)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String[] getResult() {
        return cars.stream()
                .map(Car::statusToString)
                .toArray(String[]::new);
    }

    private String[] parseCarNames(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(","))
                .map(s -> s.trim())
                .toArray(String[]::new);
    }

    private List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    private void validateCarNames(String[] carNames) {
        checkEmpty(carNames);
        validateCarNamesLength(carNames);
    }

    private void checkEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new RuntimeException("자동차 이름이 유효하지 않습니다");
        }
    }

    private void validateCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new RuntimeException("자동차 이름이 유효하지 않습니다");
        }
    }
}
