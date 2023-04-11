import java.util.*;

public class Cars {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars make(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar, 0));
        }

        return new Cars(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.go(canMove());
        }
    }

    private static boolean canMove() {
        return random.nextInt(10) >= FORWARD_CONDITION;
    }
}
