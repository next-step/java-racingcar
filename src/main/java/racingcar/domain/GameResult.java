package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<RacingCar> racingCars;

    public GameResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public  String winner() {
        int maxPosition = findMaxPosition(this.racingCars);

        return this.racingCars.stream()
                .filter(r -> r.isSamePosition(maxPosition))
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }

    protected int findMaxPosition(List<RacingCar> racingCars) {

         int maxPosition = racingCars.stream()
                                .mapToInt(racingCar -> racingCar.getPosition())
                                .max()
                                .orElse(0);
        return maxPosition;
    }
}
