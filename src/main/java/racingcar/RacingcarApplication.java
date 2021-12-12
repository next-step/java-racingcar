package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carCount = inputView.carCount();
        int labCount = inputView.labCount();

        RacingGame racingGame = new RacingGame(labCount);
        for (int i=0 ; i<carCount ; i++) {
            racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        }

        RacingResult result = racingGame.start();

        resultView.show(result);
    }

}
