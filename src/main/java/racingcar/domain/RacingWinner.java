package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {
    public static List<String> findWinnerNames(List<RacingCar> cars) {
        int highScore = getHighScore(cars);
        return cars.stream().filter(score -> score.getPosition()==highScore)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private static int getHighScore(List<RacingCar> cars) {
        return cars.stream().mapToInt(RacingCar::getPosition).max().getAsInt();

    }

}
