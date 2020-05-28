package carracing.domain;

import carracing.domain.car.Car;
import carracing.domain.car.ProgressStrategy;

public class PositionRestrictionsStrategy implements ProgressStrategy {

    private static final int stopLocation = 3;
    private Car car;

    public PositionRestrictionsStrategy(Car car) {
        this.car = car;
    }

    @Override
    public boolean progress() {
        return !car.isLocationAt(stopLocation);
    }
}
