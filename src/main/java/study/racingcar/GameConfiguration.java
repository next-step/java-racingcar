package study.racingcar;

import study.racingcar.car.Car;
import study.racingcar.car.CarName;
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
    private static int MINIMUM_CARS = 1;
    private static int MINIMUM_ATTEMPTS = 1;

    private List<CarName> carNames;
    private int numberOfCars;
    private int numberOfAttempts;
    private Engine engine;

    public GameConfiguration(String carNamesWithComma, int numberOfAttempts, Engine engine) {
        this.carNames = convertToCarName(carNamesWithComma);
        this.numberOfCars = carNames.size();
        this.numberOfAttempts = numberOfAttempts;
        this.engine = engine;

        throwIfCarsLessThan();
        throwIfAttemptsLessThan();
    }

    private List<CarName> convertToCarName(String carNamesWithComma) {

        if (Objects.isNull(carNamesWithComma)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        return Arrays.asList(carNamesWithComma.split(DELIMITER))
                .stream()
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private void throwIfCarsLessThan() {
        if (numberOfCars < MINIMUM_CARS) {
            throw new IllegalArgumentException("자동차는 " + MINIMUM_CARS + "대 이상이어야합니다.");
        }
    }

    private void throwIfAttemptsLessThan() {
        if (numberOfAttempts < MINIMUM_ATTEMPTS) {
            throw new IllegalArgumentException("최소한 " + MINIMUM_ATTEMPTS+ "번 이상의 시도를 해야합니다.");
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

