package racingCar;

import racingCar.domain.RacingGame;
import racingCar.domain.Winners;
import racingCar.domain.moveStrategy.RandomMove;
import racingCar.dto.RacingGameInfo;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        // Input
        RacingGameInfo racingGameInfo = InputView.settingRacingGame();
        RacingGame racingGame = new RacingGame(racingGameInfo);

        // OutPut
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");

        // 실행 & 출력
        int time = racingGame.getTime();
        for (int idx = 0; idx < time; idx++) {
            racingGame.move(new RandomMove());
            resultView.printCarsPosition(racingGame.getRacingCars().getRacingCarList());
        }

        // Winner
        resultView.printWinnerNames(Winners.findWinners(racingGame.getRacingCars().getRacingCarList()));
    }
}

