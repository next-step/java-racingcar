package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> makeCars(int count) {
        List<Car> cars = new ArrayList<>(count);
        for (int i=0; i<count; i++){
            cars.add(new Car());
        }
        return cars;
    }

}
