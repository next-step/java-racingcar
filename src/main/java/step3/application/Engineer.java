package step3.application;

import step3.domain.car.Car;
import step3.domain.car.Cars;
import step3.domain.car.Location;
import step3.domain.power.Power;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.utils.ValidationUtils.checkArgument;

public class Engineer {

    private static final int DEFAULT_LOCATION = 0;
    private static final int DEFAULT_POWER_BOUND = 0;

    public Cars createCars(Integer carCount, Power power) {
        checkArgument(carCount != null, "carCount is Required");
        checkArgument(power != null, "power is Required");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(DEFAULT_POWER_BOUND, Location.placeOn(DEFAULT_LOCATION)));
        }
        return new Cars(unmodifiableList(cars), power);
    }

}
