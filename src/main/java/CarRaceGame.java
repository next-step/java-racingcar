import java.util.ArrayList;

public class CarRaceGame {
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        makeCars();
        race();
    }

    private static void makeCars() {
        int carNumber = InputView.inputCarNumber();
        for (int i=0; i<carNumber; i++) {
            cars.add(new Car(0));
        }
    }

    private static void race() {
        int tryNumber = InputView.inputTryNumber();
        for (int i=0; i<tryNumber; i++) {
            moveAllCars();
            printCars();
        }
    }

    private static void moveAllCars() {
        for (Car car : cars) {
            car.randomGo();
        }
    }

    private static void printCars() {
        for (Car car : cars) {
            car.printLocation();
        }
        System.out.println();
    }
}
