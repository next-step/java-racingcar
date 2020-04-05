package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.ValidChecker;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {
    private static final String CARS_NAME_DELIMITER = ",";

    private static String carNames;
    private static int tryCnt;

    private static void gameSetting() {
        do {
            carNames = InputView.getCarNames();
        } while(!ValidChecker.checkInput(carNames));

        do {
            tryCnt = InputView.getTryCnt();
        } while (!ValidChecker.checkInput(tryCnt));
    }

    private static void playGame() {
        Cars cars = new Cars(carNames.split(CARS_NAME_DELIMITER));
        StringBuilder stringBuilder = ResultView.getResultViewBuilder();

        stringBuilder.append(positionsToString(cars));
        for (int i = 0; i < tryCnt; i++) {
            cars.playRound();
            stringBuilder.append(positionsToString(cars));
        }
        stringBuilder.append(ResultView.getRacingWinnersFormat(cars.getWinnersName(CARS_NAME_DELIMITER)));

        ResultView.printRacingResult(stringBuilder.toString());
    }

    private static String positionsToString(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars.getList()) {
            stringBuilder.append(ResultView.positionToString(car));
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        gameSetting();
        playGame();
    }
}
