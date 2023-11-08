package step3;

import java.util.Random;

public class RacingCarGame {

    public static void main (String[] arg) {
        InputView.display();
        Random random = new Random();

        GameSetup gameSetup = new GameSetup(InputView.numCar, InputView.numAttempt, random);

        for (int i = 0; i < InputView.numAttempt; i++) {
            gameSetup.moveCar(random);
            System.out.println("******** "+(i+1)+" 라운드 ********"); // 라운드별 구분자
            ResultView.display(gameSetup.cars);
        }
    }
}
