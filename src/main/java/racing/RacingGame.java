package racing;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {
    public static void playGame() {
        int carCnt = InputView.getCarCnt();
        int tryCnt = InputView.getTryCnt();

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
