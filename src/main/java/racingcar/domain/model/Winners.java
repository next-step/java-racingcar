package racingcar.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private RacingCars winners;

    private Winners(RacingCars winners) {
        this.winners = winners;
    }

    public static Winners of(RacingCars winners) {
        return new Winners(winners);
    }

    public String getNames() {
        return String.join(",", extractNames());
    }

    private List<String> extractNames() {
        return winners.findAll().stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
