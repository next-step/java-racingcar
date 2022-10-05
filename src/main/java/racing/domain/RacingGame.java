package racing.domain;

import racing.domain.car.Car;

import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;

    public RacingGame(List<Car> cars) {
        this.carGroup = new CarGroup(cars);
    }

    public CarGroup runRound() {
        return carGroup.moveAll();
    }

    public List<Car> winner() {
        return carGroup.leadingGroup();
    }
}
