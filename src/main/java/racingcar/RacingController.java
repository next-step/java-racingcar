package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    final int MOVE_THRESHOLD = 4;

    View view = new Step4View();
    Racing racing;

    public void playGame() {
        List<String> carNames = view.getCarNames();
        int numberOfRacing = view.getNumberOfRacing();

        List<Car> cars = new ArrayList<Car>();
        carNames.forEach(name -> cars.add(new SimpleCar(name)));
        CarCollection carCollection = new CarCollection(cars);

        racing = new Racing(new RandomMovementCondition(MOVE_THRESHOLD), carCollection, numberOfRacing);
        racing.addEndOfSingleRacingListener(new Observer<Integer>() {
            @Override
            public void observe(Integer currentRacing) {
                view.printSingleRacingResult(cars);
            }
        });

        view.printTitle();
        racing.racing();

        List<String> winnersName = carCollection.getWinnersName();
        view.printWinners(winnersName);
    }
}
