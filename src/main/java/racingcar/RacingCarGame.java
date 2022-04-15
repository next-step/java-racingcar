package racingcar;

import org.jetbrains.annotations.NotNull;


public class RacingCarGame {
    public RacingCar[] racingCars;
    public int numOfRound;
    public Condition condition;

    public RacingCarGame(RacingCar[] racingCars, int numOfRound, Condition condition) {
        this.racingCars = racingCars;
        this.numOfRound = numOfRound;
        this.condition = condition;
    }

    public RacingCar[] start() {
        for (int i = 0; i < numOfRound; i++) {
            proceedRacingCars(racingCars, condition);
            ResultView.showResult(racingCars);
        }
        return racingCars;
    }

    private static void proceedRacingCars(RacingCar @NotNull [] racingCars, Condition condition) {
        for (RacingCar racingCar : racingCars) {
            if (condition.isSatisfiedBy()) {
                racingCar.proceed();
            }
        }
    }

}
