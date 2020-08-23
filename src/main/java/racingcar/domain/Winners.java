package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String createWinnerNames() {
        List<String> winnersNames = new ArrayList<>();
        for(Car winner : winners) {
            winnersNames.add(winner.getName().getName());
        }
        return String.join(", ", winnersNames);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
