import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static Cars createCars(String names) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = names.split(",");
        for (String name : nameArray) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
