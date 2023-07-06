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
    private RacingManager racingManager;
    private final NumberGenerator numberGenerator;
    private final RacingView racingView;

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
        System.out.println();
        System.out.println(racingView.getResultTitleView());
        simulate(count);
        printResult();
    }

    public void inputCarName() {
        System.out.println(this.racingView.getAskingCarNameView());
        List<Car> cars = this.racingInput.inputName();

        this.racingManager = new RacingManager(cars, this.numberGenerator);
    }

    public int inputSimulationCount() {
        System.out.println(this.racingView.getAskingCountView());
        return this.racingInput.inputCount();
    }


    public void simulate(int count) {
        System.out.println(racingView.getCarStatusView(racingManager.getCars()) + "\n");
        for (int i = 0; i < count; i++) {
            racingManager.nextStep();
            System.out.println(racingView.getCarStatusView(racingManager.getCars()) + "\n");
        }
    }

    public void printResult() {
        System.out.println(this.racingView.getWinnersView(this.racingManager.getWinners()));
    }
}
