package racing;

import racing.domain.*;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingGame {
    private static final int RANDOM_VALUE_MAX = 10;
    public static final int MOVE_CONDITION = 4;
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
            cars.playRound(getMovable());
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

    private static Movable getMovable() {
        return new Movable() {
            @Override
            public boolean isMovable() {
                return new Random().nextInt(RANDOM_VALUE_MAX) >= MOVE_CONDITION;
            }
        };
    }

    public static void main(String[] args) {
        gameSetting();
        playGame();
    }
}
