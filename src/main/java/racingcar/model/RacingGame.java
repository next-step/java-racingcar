package racingcar.model;

import java.util.List;

public class RacingGame {

    public static final int GAME_END_ROUND = 0;
    public static final int INPUT_MIN_VALUE = 0;
    private Cars cars;
    private int round;

    RacingGame(int round, Cars cars) {
        this.round = round;
        this.cars = cars;
    }

    public static RacingGame generate(int round, int carCount) {
        validateInputMin(round, "시도 횟수는 " + INPUT_MIN_VALUE + "보다 커야합니다.");
        validateInputMin(carCount, "자동차 대수는 " + INPUT_MIN_VALUE + "보다 커야합니다.");
        return new RacingGame(round, Cars.generate(carCount));
    }

    private static void validateInputMin(int count, String text) {
        if (count < 0) {
            throw new IllegalArgumentException(text);
        }
    }

    public List<Car> racing() {
        round--;
        return cars.moveAll();
    }

    public boolean isGameOver() {
        return round == GAME_END_ROUND;
    }

    public List<Car> getResult() {
        return cars.getCars();
    }
}
