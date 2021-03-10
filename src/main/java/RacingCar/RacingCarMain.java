package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;
        InputView inputView = new InputView();
        OutputView outputView = new Step4OutputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfRacing = inputView.getNumberOfRacing();

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new SimpleCar(""));
        }

        Racing racing = new Racing(new RandomMovementCondition(MOVE_THRESHOLD), cars, numberOfRacing);
        racing.addEndOfSingleRacingListener(new Observer<Integer>() {
            @Override
            public void observe(Integer currentRacing) {
                outputView.printSingleRacingResult(cars);
            }
        });

        outputView.printTitle();
        racing.racing();
        outputView.printWinners(cars);
    }
}
