package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.MIN_VALUE;

public class WinnerFinder {

    private WinnerFinder() {
    }

    public static String findWinner(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();
        int minPosition = MIN_VALUE;

        for (RacingCar racingCar : racingCars) {

            if (isNewWinner(racingCar, minPosition)) {
                minPosition = racingCar.getCarPosition();
                winners.clear();
                winners.add(racingCar);
                continue;
            }

            if (isTieWinner(racingCar, minPosition)) {
                winners.add(racingCar);
            }
        }

        return winners.stream().map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }

    private static boolean isNewWinner(RacingCar racingCar, int minPosition) {
        return minPosition < racingCar.getCarPosition();
    }

    private static boolean isTieWinner(RacingCar racingCar, int minPosition) {
        return minPosition == racingCar.getCarPosition();
    }

}
