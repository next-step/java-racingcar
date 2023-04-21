package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(Car car) {
        this.winners.add(car);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
