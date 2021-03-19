package step4.domain.racing;

import step4.domain.car.Car;

import java.util.List;

public final class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public final List<Car> winners() {
        return winners;
    }

}
