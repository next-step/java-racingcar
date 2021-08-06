package kr.co.techmoa.carracing;

import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.ui.InputView;
import kr.co.techmoa.carracing.ui.ResultView;

public class CarRacingStarter {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        RacingCarGame racingCarGame = inputView.view();

        ResultView resultView = new ResultView();
        resultView.printResult(racingCarGame);

    }
}
