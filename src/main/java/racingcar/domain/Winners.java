package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<CarDTO> winners;

    public Winners(List<CarDTO> winners) {
        this.winners = winners;
    }

    public String getWinnersName() {
        return this.winners.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(", "));
    }
}
