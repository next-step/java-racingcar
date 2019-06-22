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

    public List<String> getWinners() {
        int winnerPosition = getWinnerPosition();

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition().equals(winnerPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return 0;
        /*
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max().orElse(0);
        */
    }
}
