package car.domain.strategy;

import car.domain.Cars;

public interface RacingGameStrategy {
    void apply(Cars cars);

    boolean isSatisfied();
}
