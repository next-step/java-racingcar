package carracing.step3;

import java.util.Random;

public class Main {

    private static final int MAX_BOUND = 10;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.enterCarCount();
        int tryCount = inputView.enterTryCount();

        Cars cars = new Cars(carCount, () -> new Random().nextInt(MAX_BOUND));
        ResultView resultView = new ResultView();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAllCars();
            resultView.printResults(cars.getAllCarsTrace(), i);
        }
    }
}
