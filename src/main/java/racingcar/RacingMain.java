package racingcar;

import java.util.List;

import racingcar.service.Racing;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(new Racing(), new ResultView());
        List<Integer> input = inputView.inputRacing();
        racingGame.setInRacing(input);
    }

}