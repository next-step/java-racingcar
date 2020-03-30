package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.ValidChecker;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {
    private static final String RESULT_INFO_COMMENT = "\n실행 결과\n";

    private static String carNames;
    private static int tryCnt;

    public static void gameSetting() {
        do {
            carNames = InputView.getCarNames();
        } while(!ValidChecker.checkInput(carNames));

        do {
            tryCnt = InputView.getTryCnt();
        } while (!ValidChecker.checkInput(tryCnt));
    }

    public static void playGame() {
        Cars cars = new Cars(carNames);

        StringBuilder stringBuilder = new StringBuilder(RESULT_INFO_COMMENT);
        stringBuilder.append(positionsToString(cars));

        for (int i = 0; i < tryCnt; i++) {
            cars.playRound();
            stringBuilder.append(positionsToString(cars));
        }

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