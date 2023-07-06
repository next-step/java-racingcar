package racing;

import racing.generator.NumberGenerator;
import racing.input.RacingInput;
import racing.model.RacingManager;
import racing.output.RacingOutput;
import racing.view.RacingView;

import java.util.List;

public class RacingApplication {

    private RacingInput racingInput;
    private RacingOutput racingOutput;
    private RacingManager racingManager;
    private NumberGenerator numberGenerator;
    private RacingView racingView;


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
