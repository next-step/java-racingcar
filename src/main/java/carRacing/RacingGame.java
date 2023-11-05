package carRacing;

import carRacing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> carList;
    private final int trialCount;

    public RacingGame(int carCount, int trialCount) {
        validate(carCount, trialCount);

        this.carList = cars(carCount);
        this.trialCount = trialCount;
    }

    public void gameStart() {
        for (int i = 0; i < trialCount; i++) {
            for (Car car : carList) {
                ResultView.print(car.getPosition());
                car.move();
            }
            System.out.println();
        }
    }

    private List<Car> cars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }

        return carList;
    }

    private static void validate(int carCount, int trialCount) {
        if (carCount < 0 || trialCount < 0) {
            throw new RuntimeException();
        }
    }

}
