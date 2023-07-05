package racingcar;

import java.util.Arrays;

public class Cars {
    private final Car[] cars;

    public Cars(String rawCarNames) {
        String[] carNames = parseCarNames(rawCarNames);
        validateCarNames(carNames);
        this.cars = generateCarArray(carNames);
    }

    public Car[] getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public String[] getWinners() {
        int winnerCount = Arrays.stream(cars)
                .mapToInt(car -> car.moveCount)
                .max()
                .orElse(0);

        return Arrays.stream(cars)
                .filter(car -> car.moveCount == winnerCount)
                .map(car -> car.name)
                .toArray(String[]::new);
    }

    public String[] getResult() {
        return Arrays.stream(cars)
                .map(Car::statusToString)
                .toArray(String[]::new);
    }

    private String[] parseCarNames(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(","))
                .map(s -> s.trim())
                .toArray(String[]::new);
    }

    private Car[] generateCarArray(String[] carNames) {
        return  Arrays.stream(carNames)
                .map(name -> new Car(name))
                .toArray(Car[]::new);
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
