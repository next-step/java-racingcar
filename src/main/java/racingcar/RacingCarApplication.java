package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            Cars cars = new Cars(generateCarList(consoleReader.inputCarNames()));
            int trialCount = consoleReader.inputTrialCount();
            moveCars(cars, trialCount);
            outputView.printWinners(cars.getWinners());
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }

    private void moveCars(Cars cars, int trialCount) {
        int carCount = cars.size();
        int nowCount = 0;
        while (isRunning(nowCount, trialCount)) {
            List<Integer> movementList = randomNumberGenerator.generateRandomNumberList(carCount);
            List<CarLocationResult> carLocationResults = cars.move(movementList);
            outputView.printCurrentCarMovements(carLocationResults);
            nowCount++;
        }
    }

    private boolean isRunning(int nowCount, int trialCount) {
        return nowCount < trialCount;
    }

    private List<Car> generateCarList(String carNamesAsString) {
        List<String> carNames;

        try {
            carNames = Arrays.stream(carNamesAsString.split(",")).collect(Collectors.toList());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }

        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

}
