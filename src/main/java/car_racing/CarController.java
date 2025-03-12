package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarController {
    private static final Random random = new Random();
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
        moveCars();
        showRaceResult();
    }

    private void moveCars() {
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            cars.forEach(car -> car.move(random.nextInt()));
        }
    }

    private void showRaceResult() {

    }
}
