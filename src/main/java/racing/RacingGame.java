package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {
    private static final String INVALID_INPUT_MSG = "양의 정수 값을 입력 해 주세요!";
    private static final String RESULT_INFO_COMMENT = "\n실행 결과\n";

    private static int carCnt;
    private static int tryCnt;

    public static void gameSetting() {
        while ((carCnt = InputView.getCarCnt()) < 0) {
            System.out.println(INVALID_INPUT_MSG);
        }

        while ((tryCnt = InputView.getTryCnt()) < 0) {
            System.out.println(INVALID_INPUT_MSG);
        }
    }

    public static void playGame() {
        Cars cars = new Cars(carCnt);

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
            stringBuilder.append(ResultView.positionToString(car.getPosition()));
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        gameSetting();
        playGame();
    }
}