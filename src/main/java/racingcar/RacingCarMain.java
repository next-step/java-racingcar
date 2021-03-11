package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;

        InputView inputView = new Step4InputView();

        List<String> carNames = inputView.getCarNames();
        List<Car> cars = new ArrayList<Car>();
        carNames.forEach(name -> cars.add(new SimpleCar(name)));
        CarCollection carCollection = new CarCollection(cars);

        int numberOfRacing = inputView.getNumberOfRacing();

        OutputView outputView = new Step4OutputView();
        Racing racing = new Racing(new RandomMovementCondition(MOVE_THRESHOLD), carCollection, numberOfRacing);
        racing.addEndOfSingleRacingListener(new Observer<Integer>() {
            @Override
            public void observe(Integer currentRacing) {
                outputView.printSingleRacingResult(cars);
            }
        });

        outputView.printTitle();
        racing.racing();

        List<String> winnersName = carCollection.getWinnersName();
        outputView.printWinners(winnersName);
    }
}
