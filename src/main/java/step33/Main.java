package step33;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amountOfCar = inputView.getAmountOfCar();
        int countOfCarRacing = inputView.getCountOfCarRacing();

        CarRacing carRacing = new CarRacing(amountOfCar);
        List<CarResponse> result = carRacing.start(new RandomGenerator(new Random()), countOfCarRacing);

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
