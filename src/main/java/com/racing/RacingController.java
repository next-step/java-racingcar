package com.racing;

import com.racing.game.entity.CarRace;
import com.racing.game.view.InputView;
import com.racing.game.view.ResultView;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class RacingController {
    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;
    private final CarRace carRace;

    public RacingController(InputViewModel inputViewModel, ResultViewModel resultViewModel, CarRace carRace) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
        this.carRace = carRace;
    }

    public void startRace() {
        InputView inputView = new InputView(inputViewModel);
        inputView.drawCarCountInputView();
        inputView.drawTryCountInputView();

        carRace.race();

        ResultView resultView = new ResultView(resultViewModel);
        resultView.drawResultView();
    }
}
