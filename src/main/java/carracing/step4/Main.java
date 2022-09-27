package carracing.step4;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    private static final int MAX_BOUND = 10;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> carNames = inputView.enterCarNames();
        int tryCount = inputView.enterTryCount();

        Supplier<Integer> generateRandomNumber = () -> new Random().nextInt(MAX_BOUND);
        Cars cars = new Cars(carNames, generateRandomNumber);
        ResultView resultView = new ResultView();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAllCars();
            resultView.printEachPlayResult(cars.getAllCarsTrace(), i);
        }
        resultView.printWinner(cars.getWinner());
    }
}
