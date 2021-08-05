package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> makeCars(String[] names) {
        List<Car> cars = new ArrayList<>(names.length);
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
        return cars;
    }

}
