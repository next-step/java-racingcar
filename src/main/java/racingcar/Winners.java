package racingcar;

import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        this.winners = cars;
    }

    public List<Car> getWinners() {
        return this.winners;
    }
}
