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

    public static List<RacingCar> findWinners(RacingCar[] racingCars) {
        ArrayList<RacingCar> winners = new ArrayList<>();

        double winnerLocation = findWinnerLocation(racingCars);

        for (RacingCar racingCar : racingCars) {
            addWinner(winnerLocation, racingCar, winners);
        }
        return winners;
    }

    private static void addWinner(double winnerLocation, RacingCar racingCar, ArrayList<RacingCar> winners) {
        if (winnerLocation == racingCar.getLocation().getX()) {
            winners.add(racingCar);
        }
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
            proceedRacingCarByCondition(racingCar, condition);
        }
    }

    private static void proceedRacingCarByCondition(RacingCar racingCar, Condition condition) {
        if (condition.isSatisfied()) {
            racingCar.proceed();
        }
    }

}
