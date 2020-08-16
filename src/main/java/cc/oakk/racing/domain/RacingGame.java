package cc.oakk.racing.domain;

import cc.oakk.racing.domain.predicate.CarForwardCondition;

import java.util.List;

public class RacingGame {
    private final CarForwardCondition<?> carForwardCondition;
    private final CarFactory carFactory;

    public RacingGame(CarForwardCondition<?> carForwardCondition) {
        this.carForwardCondition = carForwardCondition;
        this.carFactory = new CarFactory(this.carForwardCondition);
    }

    public RacingRound createRound(List<String> carNames, int totalRoundCount) {
        return new RacingRound(carFactory.createCars(carNames), totalRoundCount);
    }
}
