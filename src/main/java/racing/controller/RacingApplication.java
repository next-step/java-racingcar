package racing.controller;

import racing.generator.NumberGenerator;
import racing.controller.input.RacingInput;
import racing.model.RacingManager;
import racing.view.output.RacingOutput;
import racing.view.RacingView;

import java.util.List;

public class RacingApplication {

    private final RacingInput racingInput;

    private final RacingOutput racingOutput;

    private final NumberGenerator numberGenerator;

    private final RacingView racingView;

    private RacingManager racingManager;

    public RacingApplication(RacingInput racingInput, NumberGenerator numberGenerator) {
        this.racingInput = racingInput;
        this.numberGenerator = numberGenerator;
        this.racingOutput = new RacingOutput();
        this.racingView = new RacingView();
    }

    public void run() {
        input();
        showSimulationResult();
    }

    private void input() {
        this.racingOutput.print(this.racingView.getAskingCarNameView());
        List<String> carNames = this.racingInput.inputName();

        this.racingOutput.print(this.racingView.getAskingCountView());
        int count = this.racingInput.inputCount();
        this.racingOutput.print("");

        this.racingManager = new RacingManager(carNames, this.numberGenerator, count);
    }

    private void showSimulationResult() {
        this.racingOutput.print(this.racingView.getResultView(this.racingManager.simulate()));
    }
}
