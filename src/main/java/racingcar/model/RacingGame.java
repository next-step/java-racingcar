package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

public class RacingGame {

    public static final int GAME_END_ROUND = 0;
    public static final int INPUT_MIN_ROUND = 0;
    private NumberGenerator numberGenerator;
    private Cars cars;
    private int round;

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

    public static RacingGame generate(int round, String names) {
        validateRound(round);
        Names namesList = Names.from(names);
        return new RacingGame(round, Cars.from(namesList));
    }

    private static void validateRound(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("시도 횟수는 " + INPUT_MIN_ROUND + "보다 커야합니다.");
        }
    }

    public Cars racing() {
        round--;
        return cars.move(numberGenerator);
    }

    public Cars getResult() {
        return cars;
    }

    public WinningResult getFinalResult(){
        return WinningResult.of(cars.winningCars());
    }

    public boolean isGameOver() {
        return round == GAME_END_ROUND;
    }
}
