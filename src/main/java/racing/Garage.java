package racing;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final List<Car> cars = new ArrayList<>();

    public int getNumberOfCars() {
        return this.cars.size();
    }

}
