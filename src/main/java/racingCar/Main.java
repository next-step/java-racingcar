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

        // RacingGame
        RacingGame racingGame = new RacingGame(racingGameInfo);

        // OutPut
        int time = racingGameInfo.getTime();
        for (int idx = 0; idx < time; idx++) {
            racingGame.move(new RandomMove());
            ResultView.printRacingCars(idx, racingGame.getRacingCars());
        }

        // Winner
        ResultView.printWinnerNames(Winners.findWinners(racingGame.getRacingCars()));
    }
}

