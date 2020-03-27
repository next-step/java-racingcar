package racing;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {
    private static final String INVALID_INPUT_MSG = "양의 정수 값을 입력 해 주세요!";

    public static void playGame() {
        int carCnt, tryCnt;
        while ((carCnt = InputView.getCarCnt()) < 0) {
            System.out.println(INVALID_INPUT_MSG);
        }

        while ((tryCnt = InputView.getTryCnt()) < 0) {
            System.out.println(INVALID_INPUT_MSG);
        };

        Cars cars = new Cars(carCnt);

        ResultView.printResultInfoComment();
        for (int i = 0; i < tryCnt; i++) {
            cars.playRound();
            ResultView.printCarsState(cars.getCarsPositionList());
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
