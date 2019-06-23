package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<RacingCar> winners;

    private Winners(List<RacingCar> racingCars) {
        this.winners = racingCars;
    }

    public static Winners of(List<RacingCar> racingCars) {
        return new Winners(racingCars);
    }

    public String getNames() {
        return String.join(",", extractNames());
    }

    private List<String> extractNames() {
        return winners.stream()
                .map(racingCar -> racingCar.getName())
                .collect(Collectors.toList());
    }
}
