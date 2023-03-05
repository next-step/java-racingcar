package racingcar.racing;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utility.InitializeUtility.initCar;
import static racingcar.utility.InitializeUtility.initTotalAttempt;
import static racingcar.utility.RandomUtility.getRandomNumber;
import static racingcar.view.Input.getAttemptCount;
import static racingcar.view.Input.getCarNames;
import static racingcar.view.Output.*;

public class RacingGame {
    private static final int ZERO = 0;
    private static final int FIRST_INDEX = 0;

    private List<Car> carList = new ArrayList<>();
    private int totalAttemptCount;

    public void start() throws IllegalArgumentException {
        initRacingCarGame();
        startMessage();

        while (totalAttemptCount --> ZERO) {
            run();
        }

        List<String> winnerNameList = getWinners();
        printWinners(winnerNameList);
    }

    private void initRacingCarGame() throws IllegalArgumentException {
        String carNames = getCarNames();
        carList = initCar(carNames);

        String attempt = getAttemptCount();
        totalAttemptCount = initTotalAttempt(attempt);
    }

    private void run() {
        for (Car car : carList) {
            car.progress(getRandomNumber());
        }
        printProgress();
        printLine();
    }

    private void printProgress() {
        for (Car car : carList) {
            String carName = car.getName();
            int position = car.getPosition();

            Output.printProgress(carName, position);
        }
    }

    private List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        int maxPosition = carList.get(FIRST_INDEX).getPosition();

        return maxPosition;
    }
}
