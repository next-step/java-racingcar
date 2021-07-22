package racing.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    public void allMove() {
        for(Car iCar : values)
            iCar.move();
    }

    public void add(Car car) {
        values.add(car);
    }

    public int size() {
        return values.size();
    }
}
