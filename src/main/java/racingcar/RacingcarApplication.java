package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarNames;
import racingcar.domain.RacingResult;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingCarNames carNames = inputView.carNames();
        int labCount = inputView.labCount();

        RacingGame racingGame = new RacingGame(labCount);
        for (int i=0 ; i<carNames.size() ; i++) {
            racingGame.registerCar(new RacingCar(carNames.get(i), RandomMovingStrategy.getInatance()));
        }

        RacingResult result = racingGame.start();

        resultView.show(result);
    }

}
