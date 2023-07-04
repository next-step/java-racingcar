package racing;

import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;
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

    public RacingApplication() {
        this.racingInput = new RacingInput(System.in);
        this.racingOutput = new RacingOutput();
        this.numberGenerator = new RandomNumberGenerator();
        this.racingView = new RacingView();
    }

    public RacingApplication(RacingInput racingInput, NumberGenerator numberGenerator) {
        this.racingInput = racingInput;
        this.numberGenerator = numberGenerator;
        this.racingOutput = new RacingOutput();
        this.racingView = new RacingView();
    }

    public void run() {
        input();
        racingOutput.print(this.racingView.getResultView(this.racingManager.simulate()));
    }

    public void input() {
        this.racingOutput.print(this.racingView.getAskingCarNameView());
        List<Car> cars = this.racingInput.inputName();

        this.racingOutput.print(this.racingView.getAskingCountView());
        int count = this.racingInput.inputCount();
        this.racingOutput.print("");

        this.racingManager = new RacingManager(cars, this.numberGenerator, count);
    }

}
