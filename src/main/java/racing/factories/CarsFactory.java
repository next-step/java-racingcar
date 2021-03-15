package racing.factories;

import racing.models.Car;
import racing.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static Cars createFrom(int count) {
        final List<Car> carList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            carList.add(new Car());
        }

        return new Cars(carList);
    }

    public static Cars createFrom(String[] names) {
        final List<Car> carList = new ArrayList<>();

        for (final String name : names) {
            carList.add(new Car(name));
        }

        return new Cars(carList);
    }
}
