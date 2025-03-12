package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarController {
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final List<Car> cars;
    private final UserInput userInput;

    public CarController(UserInput userInput) {
        this.userInput = userInput;
        this.cars = new ArrayList<>();
        for (int i = 0; i < userInput.getNumOfCar(); i++) {
            this.cars.add(new Car());
        }
    }

    public void race() {
        showRaceStart();
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            moveCars();
            showRaceResult();
        }
    }

    private void moveCars() {
        cars.forEach(this::randomMove);
    }

    private void randomMove(Car car) {
        int randomNum = random.nextInt();
        if (randomNum >= MOVE_THRESHOLD) {
            car.move(DEFAULT_MOVE_DISTANCE);
        }
    }

    private void showRaceStart() {
        CarPrinter.showRaceStart();
    }

    private void showRaceResult() {
        CarPrinter.showRaceResult(cars);
    }
}
