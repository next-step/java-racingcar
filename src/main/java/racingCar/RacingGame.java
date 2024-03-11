package racingCar;


import static view.InputView.inputNumberOfCars;
import static view.InputView.inputNumberOfTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final Random random = new Random();
    private final MoveStrategy strategy = new MoveStrategy();


    public void run() {
        List<RacingCar> cars = createCars(inputNumberOfCars());
        tryMove(cars, inputNumberOfTry());
    }

    private List<RacingCar> createCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new RacingCar(strategy));
        }
        return cars;
    }

    private void tryMove(List<RacingCar> cars, int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            moveCars(cars);
        }
    }

    private void moveCars(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.move(createRandomDistance());
        }
    }

    private int createRandomDistance() {
        return random.nextInt(10);
    }

}
