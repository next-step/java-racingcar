import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public CarFactory() {
    }

    public List<Car> create(int howManyCars, int howManyTimesTry) {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0 ; i < howManyCars; i++) {
            cars.add(Car.create(howManyTimesTry));
        }
        return cars;
    }
}
