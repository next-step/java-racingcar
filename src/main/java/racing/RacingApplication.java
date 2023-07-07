package racing;

import racing.domain.CarCollection;
import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;
import racing.input.RacingInput;
import racing.view.RacingView;

public class RacingApplication {

    private final RacingInput racingInput;
    private final NumberGenerator numberGenerator;
    private final RacingView racingView;
    private CarCollection cars;

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
        this.cars = this.racingInput.inputName();
    }

    public int inputSimulationCount() {
        this.racingView.printCountAsking();
        return this.racingInput.inputCount();
    }


    public void simulate(int count) {
        racingView.printCarStatus(cars.getCars());
        for (int i = 0; i < count; i++) {
            this.cars = cars.nextState(numberGenerator);
            racingView.printCarStatus(cars.getCars());
        }
    }

    public void printResult() {
        this.racingView.printWinners(this.cars.getWinners());
    }
}
