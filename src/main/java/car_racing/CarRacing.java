package car_racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private final List<Car> cars = new ArrayList<>();
    private final InputView inputView = new InputView();

    public static void run() {
        CarRacing carRacing = new CarRacing();
        carRacing.inputView.saveInputs();
        carRacing.initCars();
        carRacing.startRacing();
    }

    private void initCars() {
        for (int i = 0; i < inputView.carSize; i++) {
            cars.add(new Car());
        }
    }

    private void startRacing() {
        for (int i = 0; i < inputView.trySize; i++) {
            moveCars();
            ResultView.printMovingOfCars(cars);
            System.out.println();
        }
    }

    private void moveCars() {
        for (int i = 0; i < inputView.carSize; i++) {
            cars.get(i).moveOrStop();
        }
    }

    public static void main(String[] args) {
        CarRacing.run();
    }
}
