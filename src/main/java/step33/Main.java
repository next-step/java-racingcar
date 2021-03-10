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

        List<Car> cars = IntStream.range(0, amountOfCar)
                .mapToObj(amount -> new Car())
                .collect(Collectors.toList());

        CarRacing carRacing = new CarRacing(cars);
        List<CarResponse> result = carRacing.start(new RandomGenerator(new Random()), countOfCarRacing);

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
