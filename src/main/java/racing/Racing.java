package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();

    public List<Car> ready(int numberOfCar) {
        for(int i = 0; i < numberOfCar; ++i) {
            cars.add(new Car());
        }
        return this.cars;
    }
 }
