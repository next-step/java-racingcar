package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int count) {
        for (int j = 0; j < count; j++) {
            cars.add(new Car());
        }
    }

    public int size() {
        return cars.size();
    }
}
