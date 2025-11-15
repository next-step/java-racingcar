package racinggame;

import static racinggame.ui.MC.*;
import static racinggame.ui.MC.askCarNamesToUser;
import static racinggame.ui.MC.printEndMessage;
import static racinggame.ui.MC.printLineBreaker;
import static racinggame.ui.ResultView.printCarPositionTitle;
import static racinggame.utils.StringUtils.splitToList;

import java.util.List;
import racinggame.car.Car;
import racinggame.car.Cars;
import racinggame.ui.MC;
import racinggame.ui.UserInput;
import racinggame.utils.StringUtils;

public class RacingGame {
    public static final String CAR_NAME_DELIMITER = ",";

    public void start() {
        UserInput userInput = getUserInput();
        List<String> carNameList = splitToList(
                userInput.getCarNames(),
                CAR_NAME_DELIMITER
        );

        startRacing(
                userInput.getTryCount(),
                Cars.createByNames(carNameList)
        );
    }

    private void startRacing(int tryCount, Cars cars) {
        printCarPositionTitle();

        processGame(tryCount, cars);

        reportWinnerAndEndGame(cars);
    }

    private void processGame(int tryCount, Cars cars) {
        for (int perTry = 0; perTry < tryCount; perTry++) {
            cars.playPerRound();
            printLineBreaker();
        }
    }

    private void reportWinnerAndEndGame(Cars cars) {
        List<String> winners = cars.findWinners(cars.findMaxPositions());
        printEndMessage(winners);
    }
}
