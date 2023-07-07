package racing.controller;

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
        this(new RacingInput(System.in), new RandomNumberGenerator());
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

    private void inputCarName() {
        racingView.printCarNameAsking();
        this.cars = this.racingInput.inputName();
    }

    private int inputSimulationCount() {
        this.racingView.printCountAsking();
        return this.racingInput.inputCount();
    }


    private void simulate(int count) {
        racingView.printCarStatus(cars);
        for (int i = 0; i < count; i++) {
            this.cars = cars.nextState(numberGenerator);
            racingView.printCarStatus(cars);
        }
    }

    private void printResult() {
        this.racingView.printWinners(this.cars.getWinners());
    }
}
