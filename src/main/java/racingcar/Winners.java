package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<CarDTO> winners;

    Winners(List<CarDTO> winners) {
        this.winners = winners;
    }

    String getWinnersName() {
        return this.winners.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(", "));
    }
}
