package racingcar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class RacingCarGame {
    public RacingCar[] racingCars;
    public int numOfRound;
    public Condition condition;

    public RacingCarGame(RacingCar[] racingCars, int numOfRound, Condition condition) {
        this.racingCars = racingCars;
        this.numOfRound = numOfRound;
        this.condition = condition;
    }

    private static double findWinnerLocation(RacingCar[] racingCars) {
        double max = 0;

        for (RacingCar racingCar : racingCars) {
            max = FindGreaterLocation(max, racingCar.getLocation().getX());
        }
        return max;
    }

    private static double FindGreaterLocation(double max, double x) {
        if (max >= x) {
            return max;
        }
        return x;
    }

    public static List<String> findWinners(RacingCar[] racingCars) {
        List<String> winners = new ArrayList<>();

        double winnerLocation = findWinnerLocation(racingCars);

        for (RacingCar racingCar : racingCars) {
            addWinner(winnerLocation, racingCar, winners);
        }
        return winners;
    }

    private static void addWinner(double winnerLocation, RacingCar racingCar, List<String> winners) {
        if (winnerLocation == racingCar.getLocation().getX()) {
            winners.add(racingCar.getName());
        }
    }


    public RacingCar[] start() {
        for (int i = 0; i < numOfRound; i++) {
            proceedRacingCars(racingCars, condition);
            ResultView.showResult(racingCars);
        }
        ResultView.showWinners(racingCars);
        return racingCars;
    }

    private static void proceedRacingCars(RacingCar @NotNull [] racingCars, Condition condition) {
        for (RacingCar racingCar : racingCars) {
            proceedRacingCarByCondition(racingCar, condition);
        }
    }

    private static void proceedRacingCarByCondition(RacingCar racingCar, Condition condition) {
        if (condition.isSatisfied()) {
            racingCar.proceed();
        }
    }

}
