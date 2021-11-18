package racingcargamefinal.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    @Override
    public String toString() {
        return getWinners().stream()
                .map(winner -> winner.getName().getValue())
                .collect(Collectors.joining(","));
    }

}
