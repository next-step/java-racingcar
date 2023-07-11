package racingcar.dto;

import java.util.List;

public class Winners {
    private final List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = List.copyOf(winners);
    }

    public List<Winner> get() {
        return List.copyOf(winners);
    }
}
