package racingCar;

import racingCar.Application.RacingGame;
import racingCar.UI.InputView;
import racingCar.UI.ResultView;

public class Main {
    public static void main(String[] args) {
        //Input
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.setStartInput();

        // Init Position RacingCar
        racingGame.initRacingCars();

        //OutPut
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");

        //실행 & 출력
        int time = racingGame.getTime();
        for (int idx = 0; idx < time; idx++) {
            racingGame.move();
            resultView.printCarsPosition(racingGame.getRacingCarList());
        }
    }
}

