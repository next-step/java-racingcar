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
            cars.add(new Car(carName));
        }

        ResultView.printResultStartMessage();
        for (int i=0; i< tryNumber.getValue(); i++) {
            forward();
            System.out.println();
        }
        ResultView.printWinner(cars);

    }
    public void forward() {
        for(Car car : cars) {
            car.move(this.randomUtil.randomCount(RANDOM_NUMBER));
        }
        ResultView.printResult(cars);
    }
}
