package racing;

import racing.controller.GameSetup;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGame {

    public static void main (String[] arg) {
        InputView.display();

        GameSetup gameSetup = new GameSetup(InputView.getNumberOfCar(), InputView.getNumAttempt());

        for (int i = 0; i < InputView.getNumAttempt(); i++) {
            gameSetup.moveCar();

            System.out.println("******** "+(i+1)+" 라운드 ********"); // 라운드별 구분자
            ResultView.display(gameSetup.cars);
        }
    }
}
