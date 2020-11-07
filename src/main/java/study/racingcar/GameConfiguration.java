package study.racingcar;

import study.racingcar.car.Car;
import study.racingcar.car.Engine;
import study.racingcar.racingcars.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 게임의 설정 값을 가지고 RacingCar를 초기화하는 책임 
 */
public class GameConfiguration {

    private static final String DELIMITER = ",";

    private List<String> carNames;
    private int numberOfCars;
    private int numberOfAttempts;
    private Engine engine;

    public GameConfiguration(String carNamesWithComma, int numberOfAttempts, Engine engine) {
        this.carNames = splitCarName(carNamesWithComma);
        this.numberOfCars = carNames.size();
        this.numberOfAttempts = numberOfAttempts;
        this.engine = engine;

        validate();
    }

    private List<String> splitCarName(String carNamesWithComma) {

        if (Objects.isNull(carNamesWithComma)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        return Arrays.asList(carNamesWithComma.split(DELIMITER));
    }

    private void validate (){

        if (numberOfCars < 1) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야합니다.");
        }

        boolean existOverLengthLimit = carNames.stream()
                .anyMatch(carName -> carName.length() > 5);
        if (existOverLengthLimit) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        boolean existBlank = carNames.stream().anyMatch(String::isEmpty);

        if (existBlank) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (numberOfAttempts < 1) {
            throw new IllegalArgumentException("최소한 1번 이상의 시도를 해야합니다.");
        }
    }

    public RacingCars initRacingCars() {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars, engine);
    }

    public boolean doMoreAttempt(int currentAttempt) {
        return currentAttempt < numberOfAttempts;
    }

}

