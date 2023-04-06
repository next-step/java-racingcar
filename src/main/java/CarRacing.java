import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final Random random = new Random();

    public static void main(String[] args) {

        int numberOfCar = InputView.numberOfCar();
        int trial = InputView.trial();

        List<Car> cars = cars(numberOfCar);

        for (int i = 0; i < numberOfCar; i++) {
            Car car = cars.get(i);
            car.go(random.nextInt(10));
        }
    }

    private static List<Car> cars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
