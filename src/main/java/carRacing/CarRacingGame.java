package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final int RANDOM_NUMBER = 10;
    private RandomUtil randomUtil = new RandomUtil();
    private List<Car> cars = new ArrayList<>();

    public  void start() {
        String[] carNameInputs = InputView.carNameInput();
        TryNumber tryNumber = new TryNumber(InputView.tryInput());
        for (String carName: carNameInputs) {
            cars.add(new Car(new Name(carName)));
        }

        ResultView.printResultStartMessage();
        while (tryNumber.hasRemainingTryNumber()) {
            forward();
            ResultView.printResult(cars);
            tryNumber.decrease();
        }
        Winner winner = new Winner(cars);
        ResultView.printWinner(winner.findWinner());

    }
    public void forward() {
        for(Car car : cars) {
            car.move(this.randomUtil.randomCount(RANDOM_NUMBER));
        }
    }
}
