package racingcar;

import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class RacingGame {

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND = 1;

    private int round;
    private Car[] cars;

    public RacingGame(int round, String[] carNames) {
        validate(round, carNames);
        this.round = round;
        this.cars = generateCars(carNames);
    }

    public Car[] getCars() {
        return cars;
    }

    private Car[] generateCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = Car.newInstance(carNames[i]);
        }
        return cars;
    }

    public int[] play() {
        IntStream.range(0, round)
                .mapToObj(value -> moveAll())
                .forEach(ResultView::printCarPositionPerRound);

        return Arrays.stream(cars)
                .mapToInt(Car::getPosition)
                .toArray();
    };

    private int[] moveAll() {
      return Arrays.stream(cars)
                .mapToInt(Car::move)
                .toArray();
    }

    private void validate(int gameRound, String[] carNames){
        if(Objects.isNull(carNames) || carNames.length < MINIMUM_CAR_COUNT){
            throw new IllegalArgumentException("최소 자동차 대수 입력 값은 " + MINIMUM_CAR_COUNT + " 입니다.");
        }
        if(gameRound < MINIMUM_ROUND){
            throw new IllegalArgumentException("최소 게임 라운드 입력 값은 " + MINIMUM_ROUND + " 입니다.");
        }
    }
}