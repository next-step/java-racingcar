package racing;

import racing.domain.Car;
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
        inputCarName();
        int count = inputSimulationCount();
        this.racingOutput.print("");
        this.racingOutput.print(racingView.getResultTitleView());
        simulate(count);
        printResult();
    }

    public void inputCarName() {
        this.racingOutput.print(this.racingView.getAskingCarNameView());
        List<Car> cars = this.racingInput.inputName();

        this.racingManager = new RacingManager(cars, this.numberGenerator);
    }

    public int inputSimulationCount() {
        this.racingOutput.print(this.racingView.getAskingCountView());
        return this.racingInput.inputCount();
    }


    public void simulate(int count) {
        this.racingOutput.print(racingView.getCarStatusView(racingManager.getCars()) + "\n");
        for (int i = 0; i < count; i++) {
            racingManager.nextStep();
            this.racingOutput.print(racingView.getCarStatusView(racingManager.getCars()) + "\n");
        }
    }

    public void printResult() {
        this.racingOutput.print(this.racingView.getWinnersView(this.racingManager.getWinners()));
    }
}
