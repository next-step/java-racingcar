package racing;

import racing.domain.Car;
import racing.domain.RacingManager;
import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;
import racing.input.RacingInput;
import racing.view.RacingView;

import java.util.List;

public class RacingApplication {

    private final RacingInput racingInput;
    private final NumberGenerator numberGenerator;
    private final RacingView racingView;
    private RacingManager racingManager;

    public RacingApplication() {
        this.racingInput = new RacingInput(System.in);
        this.numberGenerator = new RandomNumberGenerator();
        this.racingView = new RacingView();
    }

    public RacingApplication(RacingInput racingInput, NumberGenerator numberGenerator) {
        this.racingInput = racingInput;
        this.numberGenerator = numberGenerator;
        this.racingView = new RacingView();
    }

    public void run() {
        inputCarName();
        int count = inputSimulationCount();
        racingView.printResultTitle();
        simulate(count);
        printResult();
    }

    public void inputCarName() {
        racingView.printCarNameAsking();
        List<Car> cars = this.racingInput.inputName();

        this.racingManager = new RacingManager(cars, this.numberGenerator);
    }

    public int inputSimulationCount() {
        this.racingView.printCountAsking();
        return this.racingInput.inputCount();
    }


    public void simulate(int count) {
        racingView.printCarStatus(racingManager.getCars());
        for (int i = 0; i < count; i++) {
            racingManager.nextStep();
            racingView.printCarStatus(racingManager.getCars());
        }
    }

    public void printResult() {
        this.racingView.printWinners(this.racingManager.getWinners());
    }
}
