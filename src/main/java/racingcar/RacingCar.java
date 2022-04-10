package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {
    private final InputView inputView;
    private final NumberGenerator numberGenerator;
    private final ResultView resultView;

    public RacingCar(InputView inputView, NumberGenerator numberGenerator, ResultView resultView) {
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
        this.resultView = resultView;
    }

    public void run() {
        int carCount = inputView.inputCarCount();
        int roundCount = inputView.inputRoundCount();

        List<Car> cars = generateCars(carCount);

        cars.forEach(c -> {
            List<Integer> integers = numberGenerator.generateRandomNumbers(roundCount);
            c.move(integers);
            resultView.printResult(c.getCurrentLocation());
        });

    }

    private List<Car> generateCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(n -> new Car())
                .collect(Collectors.toList());
    }

}
