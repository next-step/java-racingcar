package racinggame.domain;


import java.util.ArrayList;
import java.util.List;

public class NeverMoveCars extends Cars {

    public NeverMoveCars(CarsNames carsNames) {
        super(initialCars(carsNames));
    }

    private static List<Car> initialCars(CarsNames carsNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.size(); i++) {
            cars.add(new NeverMoveCar(carsNames.getName(i)));
        }
        return cars;
    }
}
