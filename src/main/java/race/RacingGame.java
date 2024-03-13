package race;

import race.domain.Cars;
import race.utils.RaceRule;
import race.view.InputView;
import race.view.OutputView;

import java.util.List;

public class RacingGame {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        int carNumbers = inputView.askNumberOfCars();
        int attempts = inputView.askNumberOfAttempts();
        Cars cars = new Cars(carNumbers);
        outputView.printResultStatement();
        for (int attempt = 0; attempt < attempts; attempt++) {
            List<Integer> points = cars.goForward(new RaceRule());
            outputView.printMileages(points);
            outputView.printNewLine();
        }
    }

}
