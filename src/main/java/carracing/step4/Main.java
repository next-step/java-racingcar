package carracing.step4;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
            List<CarVo> carVos = cars.getAllCars()
                    .stream()
                    .map(CarVo::new)
                    .collect(toList());
            resultView.printEachPlayResult(carVos, i);
        }
        resultView.printWinner(cars.getWinner());
    }
}
