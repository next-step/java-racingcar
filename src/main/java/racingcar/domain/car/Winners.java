package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public List<Car> winners() {
        return new ArrayList<>(this.winners);
    }

    public static Winners emptyWinners() {
        return new Winners(new ArrayList<>());
    }

    public boolean isEmpty() {
        return this.winners.isEmpty();
    }
}
