package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND = 1;

    private int round;
    private Cars cars;

    public RacingGame(int round, String[] carNames) {
        validate(round, carNames);
        this.round = round;
        this.cars = generateCars(carNames);
    }

    public Cars getCars() {
        return cars;
    }

    private Cars generateCars(String[] carNames) {
        List<Car> carList = Arrays.stream(carNames)
                .map(CarName::of)
                .map(Car::newInstance)
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    public RacingGameResult play() {

        cars.clearAll();

        RacingGameResult racingGameResult = new RacingGameResult();
        racingGameResult.addFromCars(cars);
        IntStream.range(0, round)
                .forEach(value -> {
                    cars.moveAll();
                    racingGameResult.addFromCars(cars);
                });

        return racingGameResult;
    }

    private void validate(int gameRound, String[] carNames) {
        if (Objects.isNull(carNames) || carNames.length < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("최소 자동차 대수 입력 값은 " + MINIMUM_CAR_COUNT + " 입니다.");
        }
        if (gameRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException("최소 게임 라운드 입력 값은 " + MINIMUM_ROUND + " 입니다.");
        }
    }
}