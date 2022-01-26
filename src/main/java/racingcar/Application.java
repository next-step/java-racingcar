package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.gettryNo();
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while( !racingGame.isEnd()){
            racingGame.race();
        }
    }
}
