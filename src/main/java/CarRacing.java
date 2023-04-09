import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;

    public static void main(String[] args) {

        String[] nameOfCars = InputView.splitNameOfCars();
        int trial = InputView.trial();

        List<Car> cars = cars(numberOfCar);

        PrintView.printTitle();

        for (int i = 0; i < trial; i++) {
            moveAndPrintCar(cars);
        }
    }

    private static List<Car> cars(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar, 0));
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
