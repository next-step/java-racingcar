package race;

import race.domain.Cars;
import race.utils.RandomStrategy;
import race.view.InputView;
import race.view.OutputView;

public class RacingGame {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        String[] names = inputView.askNameOfCar();
        int attempts = inputView.askNumberOfAttempts();

        outputView.printResultStatement();

        Cars cars = new Cars(names);
        for (int attempt = 0; attempt < attempts; attempt++) {
            outputView.printMileages(cars.goForward(new RandomStrategy()));
            outputView.printNewLine();
        }
        System.out.print(cars.showWinnerNames());
    }

}
