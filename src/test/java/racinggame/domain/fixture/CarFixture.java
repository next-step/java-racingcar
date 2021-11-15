package racinggame.domain.fixture;

import racinggame.domain.Car;
import racinggame.domain.Name;

public class CarFixture {
    public static final String ENTRY_CAR_NAME = "jae";

    public static Car createCar() throws Exception {
        return new Car(new Name(CarFixture.ENTRY_CAR_NAME));
    }
}
