package car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory implements CarFactory {

    @Override
    public RacingCar generateCar() {
        return new RacingCar(new CarMovableStrategy());
    }
}
