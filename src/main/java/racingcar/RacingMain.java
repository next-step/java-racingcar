package racingcar;

import java.util.List;

import racingcar.service.RacingGame;
import racingcar.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        
        List<Integer> input = inputView.inputRacing();
        racingGame.setInRacing(input);
    }

}