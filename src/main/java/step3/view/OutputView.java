package step3.view;

import step3.domain.CarRacingGame;

public class OutputView {

    public static void printResult(CarRacingGame carRacingGame) {
        System.out.println("실행 결과");
        carRacingGame.printFinalResult();
    }
}