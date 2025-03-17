import java.util.ArrayList;
import java.util.Random;

public class CarRaceGame {
    private static final ArrayList<Car> cars = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        makeCars();
        race();
    }

    private static void makeCars() {
        int carNumber = InputView.inputCarNumber();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(0));
        }
    }

    private static void race() {
        int tryNumber = InputView.inputTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            moveAllCars();
            printCars();
        }
    }

    private static void moveAllCars() {
        for (Car car : cars) {
            car.randomGo(random.nextInt(10));
        }
    }

    private static void printCars() {
        for (Car car : cars) {
            ResultView.printCarLocation(car);
        }
        System.out.println();
    }
}
