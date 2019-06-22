package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public List<RacingCar> findWinners() {
        return filterWinners(getWinnerPosition());
    }

    private List<RacingCar> filterWinners(int winnerPosition) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }
    private int getWinnerPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max().orElse(0);
    }
}
