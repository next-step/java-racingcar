import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    public static void main(String[] args) {

        int numberOfCar = InputView.numberOfCar();
        int trial = InputView.trial();

        List<Car> cars = cars(numberOfCar);
    }

    private static List<Car> cars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
