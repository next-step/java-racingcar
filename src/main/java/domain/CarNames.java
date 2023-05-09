package domain;

import java.util.List;

public class CarNames {
    public static NumberOfCars toNumberOfCars(List<CarName> receive) {
        return new NumberOfCars(receive.size());
    }
}
