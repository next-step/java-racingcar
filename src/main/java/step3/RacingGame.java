package step3;

import step3.view.InputView;

public class RacingGame {

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        int carNum = InputView.askNumberOfCars();
        int roundNum = InputView.askNumberOfRounds();
    }

}
