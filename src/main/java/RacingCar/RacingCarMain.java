package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;

        InputView inputView = new Step4InputView();
        List<String> carNames = inputView.getCarNames();
        int numberOfRacing = inputView.getNumberOfRacing();

        List<Car> cars = new ArrayList<Car>();
        carNames.forEach(name -> cars.add(new SimpleCar(name)));


        OutputView outputView = new Step4OutputView();

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
