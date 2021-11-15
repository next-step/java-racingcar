package racinggame.domain.fixture;

import racinggame.domain.Cars;

public class CarsFixture {

    public static Cars createCars(int location) throws Exception {
        return Cars.of(NamesFixture.createNames(), location);
    }
}
