package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;

        InputView<String[]> inputView = new Step4InputView();
        String[] carNames = inputView.getCarInfo();
        int numberOfRacing = inputView.getNumberOfRacing();

        List<Car> cars = new ArrayList<Car>();
        for (int carNameIndex = 0; carNameIndex < carNames.length; carNameIndex++) {
            cars.add(new SimpleCar(carNames[carNameIndex]));
        }

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
