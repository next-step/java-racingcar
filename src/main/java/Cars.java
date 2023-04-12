import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars make(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar));
        }

        return new Cars(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    public void move() {
        boolean condition = new RandomStrategy().movable();
        for (Car car : cars) {
            car.go(condition);
        }
    }
}
