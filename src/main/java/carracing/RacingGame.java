package carracing;

import carracing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> carList;
    private final int trialCount;
    RandomCreate random = new RandomCreate();

    public RacingGame(int carCount, int trialCount) {

        this.carList = cars(negativeNumberCheck(carCount));
        this.trialCount = negativeNumberCheck(trialCount);
    }

    public void gameStart() {
        for (int i = 0; i < trialCount; i++) {
            for (Car car : carList) {
                ResultView.print(car.getPosition());
                car.move(random.randomNumber());
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

    private static int negativeNumberCheck(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

}
