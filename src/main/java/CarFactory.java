import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public CarFactory() {
    }

    public Cars create(int howManyCars, int howManyTimesTry) {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0 ; i < howManyCars; i++) {
            cars.add(Car.create(howManyTimesTry));
        }
        return new Cars(cars);
    }
}
