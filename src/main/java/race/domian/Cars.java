package race.domian;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static List<Car> from(int num) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
