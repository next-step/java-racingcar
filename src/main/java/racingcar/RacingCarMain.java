package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;

        View view = new Step4View();

        List<String> carNames = view.getCarNames();
        List<Car> cars = new ArrayList<Car>();
        carNames.forEach(name -> cars.add(new SimpleCar(name)));
        CarCollection carCollection = new CarCollection(cars);

        int numberOfRacing = view.getNumberOfRacing();

        Racing racing = new Racing(new RandomMovementCondition(MOVE_THRESHOLD), carCollection, numberOfRacing);
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
