package com.racing;

import com.racing.game.CarRace;
import com.racing.game.dto.RaceEntry;
import com.racing.game.view.InputView;
import com.racing.game.view.ResultView;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class RacingController {
    private InputViewModel inputViewModel;
    private ResultViewModel resultViewModel;

    public RacingController(InputViewModel inputViewModel, ResultViewModel resultViewModel) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
    }

    public void startRace() {
        InputView inputView = new InputView(inputViewModel);
        inputView.drawCarCountInputView();
        inputView.drawTryCountInputView();

        resultViewModel.saveRaceResult(
                CarRace.race(RaceEntry.of(inputViewModel.carCount().value(), inputViewModel.tryCount().value())));
        ResultView resultView = new ResultView(resultViewModel);
        resultView.drawResultView();
    }
}
