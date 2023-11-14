package com.racing;

import com.racing.game.entity.Circuit;
import com.racing.game.view.InputView;
import com.racing.game.view.ResultView;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class RacingController {
    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;
    private final Circuit circuit;

    public RacingController(InputViewModel inputViewModel, ResultViewModel resultViewModel, Circuit circuit) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
        this.circuit = circuit;
    }

    public void startRace() {
        InputView inputView = new InputView(inputViewModel);
        inputView.drawCarCountInputView();
        inputView.drawTryCountInputView();

        circuit.startRace();

        ResultView resultView = new ResultView(resultViewModel);
        resultView.drawResultView();
        resultView.drawWinnersView();
    }
}
