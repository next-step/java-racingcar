import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isSize(int size) {
        return cars.size() == size;
    }
}
