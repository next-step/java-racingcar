import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public List<Car> makeCars(int countCar) {
        for (int i = 0; i < countCar; i++) {
            cars.add(new Car("",0));
        }
        return cars;
    }
}