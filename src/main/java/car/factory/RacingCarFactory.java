package car.factory;

import car.domain.RacingCar;
import car.strategy.CarMovableStrategy;

public class RacingCarFactory implements CarFactory {

    @Override
    public RacingCar generateCar() {
        return new RacingCar(new CarMovableStrategy());
    }
}
