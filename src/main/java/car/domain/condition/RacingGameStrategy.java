package car.domain.condition;

import car.domain.Cars;

public interface RacingGameStrategy {
    void apply(Cars cars);

    boolean isSatisfied();
}
