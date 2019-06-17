package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

public class RacingGame {

    public static final int GAME_END_ROUND = 0;
    public static final int INPUT_MIN_VALUE = 0;
    private Cars cars;
    private int round;
    private NumberGenerator numberGenerator;

    private RacingGame(int round, Cars cars) {
        this.round = round;
        this.cars = cars;
        this.numberGenerator = new RandomGenerator();
    }

    RacingGame(int round, Cars cars, NumberGenerator numberGenerator) {
        this.round = round;
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static RacingGame generate(int round, int carCount) {
        validateInputMin(round, "시도 횟수는 " + INPUT_MIN_VALUE + "보다 커야합니다.");
        validateInputMin(carCount, "자동차 대수는 " + INPUT_MIN_VALUE + "보다 커야합니다.");
        return new RacingGame(round, Cars.newInstance(carCount));
    }

    private static void validateInputMin(int count, String text) {
        if (count < 0) {
            throw new IllegalArgumentException(text);
        }
    }

    public Cars racing() {
        round--;
        return cars.moveAll(numberGenerator);
    }

    public boolean isGameOver() {
        return round == GAME_END_ROUND;
    }

    public Cars getResult() {
        return cars;
    }
}
