package step3.application;

import step3.domain.car.Car;
import step3.domain.car.Cars;
import step3.domain.car.Location;
import step3.domain.power.Engine;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.utils.ValidationUtils.checkArgument;

public class Engineer {

    private static final int DEFAULT_LOCATION = 0;

    public static Cars createCars(Integer carCount, Engine engine) {
        checkArgument(carCount != null, "carCount is Required");
        checkArgument(engine != null, "engine is Required");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(Location.placeOn(DEFAULT_LOCATION));
            cars.add(car);
        }
        return new Cars(unmodifiableList(cars), engine);
    }

}
