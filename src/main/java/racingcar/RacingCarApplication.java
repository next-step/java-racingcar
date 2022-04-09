package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarApplication {

    private final ConsoleReader consoleReader;

    private final OutputView outputView;

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarApplication(
            ConsoleReader consoleReader,
            OutputView outputView,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.consoleReader = consoleReader;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        int carCount = consoleReader.inputCarCount();
        int trialCount = consoleReader.inputTrialCount();
        moveCars(carCount, trialCount);
    }

    private void moveCars(int carCount, int trialCount) {
        List<Car> carList = generateCarList(carCount);
        Cars cars = new Cars(carList);

        int nowCount = 0;
        while (!isFinished(nowCount, trialCount)) {
            List<Integer> movementList = randomNumberGenerator.generateRandomNumberList(carCount);
            List<Integer> currentLocations = cars.move(movementList);
            outputView.printCurrentCarMovements(currentLocations);
            nowCount++;
        }
    }

    private boolean isFinished(int nowCount, int trialCount) {
        return nowCount >= trialCount;
    }

    private List<Car> generateCarList(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(number -> new Car())
                .collect(Collectors.toList());
    }

}
