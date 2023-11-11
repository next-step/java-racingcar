package com.racing;

import com.racing.game.entity.RacingGame;
import com.racing.game.view.InputView;
import com.racing.game.view.ResultView;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class RacingController {
    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;
    private final RacingGame racingGame;

    public RacingController(InputViewModel inputViewModel, ResultViewModel resultViewModel, RacingGame racingGame) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
        this.racingGame = racingGame;
    }

    public void startRace() {
        InputView inputView = new InputView(inputViewModel);
        inputView.drawCarCountInputView();
        inputView.drawTryCountInputView();

        racingGame.race();

        ResultView resultView = new ResultView(resultViewModel);
        resultView.drawResultView();
        resultView.drawWinnersView();
    }
}
