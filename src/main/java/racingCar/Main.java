package racingCar;

import racingCar.application.RacingGame;
import racingCar.domain.RacingGameResult;
import racingCar.domain.RandomMove;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        // Input
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.settingRacingGame();

        // OutPut
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");

        // 실행 & 출력
        int time = racingGame.getTime();
        for (int idx = 0; idx < time; idx++) {
            racingGame.move(new RandomMove());
            resultView.printCarsPosition(racingGame.getRacingCarList());
        }

        // Winner
        RacingGameResult racingGameResult = new RacingGameResult(racingGame.getRacingCarList());
        resultView.printWinnerNames(racingGameResult.findWinners());
    }
}

