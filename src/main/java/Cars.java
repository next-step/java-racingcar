import java.util.ArrayList;
import java.util.List;

public class Cars {
    final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars) {
            car.play();
        }
    }

    public static Cars createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }
}
