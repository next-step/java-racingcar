package step3_pobi;

import step3_pobi.domain.RacingGame;
import step3_pobi.domain.RandomNumberMovingStrategy;
import step3_pobi.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo, new RandomNumberMovingStrategy());
        while (racingGame.racing()) {
            racingGame.race();
        }
    }
}
