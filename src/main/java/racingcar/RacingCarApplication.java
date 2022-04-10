package racingcar;

import java.util.List;

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
            List<Car> carList = generateCarList(consoleReader.inputCarNames());
            int trialCount = consoleReader.inputTrialCount();
            List<CarName> winnerCarNames = moveCars(carList, trialCount);
            outputView.printWinners(winnerCarNames);
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }

    private List<CarName> moveCars(List<Car> carList, int trialCount) {
        Cars cars = new Cars(carList);
        int carCount = cars.size();
        int nowCount = 0;

        while (isRunning(nowCount, trialCount)) {
            List<Integer> movementList = randomNumberGenerator.generateRandomNumberList(carCount);
            cars.move(movementList);
            List<CarLocationResult> carLocationResults
                    = CarLocationResultConverter.convertIntoCarLocationResult(carList);
            outputView.printCurrentCarMovements(carLocationResults);
            nowCount++;
        }

        return cars.getWinners();
    }

    private boolean isRunning(int nowCount, int trialCount) {
        return nowCount < trialCount;
    }

    private List<Car> generateCarList(String carNamesAsString) {
        List<String> carList = StringUtil.split(carNamesAsString);
        return StringToCarTransformer.convertToCarList(carList);
    }

}
