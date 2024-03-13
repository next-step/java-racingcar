package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class AlwaysMoveCars extends Cars{

    public AlwaysMoveCars(CarsNames carsNames) {
        super(initialCars(carsNames));
    }

    private static List<Car> initialCars(CarsNames carsNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.size(); i++) {
            cars.add(new AlwaysMoveCar(carsNames.getName(i)));
        }
        return cars;
    }
}
