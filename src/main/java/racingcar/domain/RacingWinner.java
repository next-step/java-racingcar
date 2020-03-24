package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {
    private static List<RacingCar> winners;
    private static int HIGH_SCORE = 0;

    public static List<String> findWinnerName(List<RacingCar> cars) {
        makeWinners(cars);
        List<String> winnerName = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerName.add(winner.getName());
        }
        return winnerName;
    }

    private static void makeWinners(List<RacingCar> cars) {
        postHighScore(cars);
        winners = cars.stream()
                .filter(racingCar -> racingCar.getPosition() == HIGH_SCORE)
                .collect(Collectors.toList());
    }

    private static void postHighScore(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            HIGH_SCORE = Math.max(car.getPosition(), HIGH_SCORE);
        }
    }

}
