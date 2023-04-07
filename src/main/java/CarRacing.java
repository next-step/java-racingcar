import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;

    public static void main(String[] args) {

        int numberOfCar = InputView.numberOfCar();
        int trial = InputView.trial();

        List<Car> cars = cars(numberOfCar);

        PrintView.printTitle();

        for (int i = 0; i < trial; i++) {
            moveAndPrintCar(cars);
        }
    }

    private static List<Car> cars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private static void moveAndPrintCar(List<Car> cars) {
        cars.forEach(car -> {
            car.go(canMove());
            PrintView.printCar(car.distance());
        });

        System.out.println();
    }

    private static boolean canMove() {
        return random.nextInt(10) >= FORWARD_CONDITION;
    }
}
