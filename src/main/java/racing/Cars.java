package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    public void addCar(Car car) {
        values.add(car);
    }
}
