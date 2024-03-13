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
        String nameOfCar = inputView.askNameOfCar();
        String[] names = nameOfCar.split(",");
        int carNumbers = names.length;
        int attempts = inputView.askNumberOfAttempts();

        outputView.printResultStatement();

        Cars cars = new Cars(carNumbers, names);
        for (int attempt = 0; attempt < attempts; attempt++) {
            List<Integer> points = cars.goForward(new RaceRule());
            outputView.printMileages(points);
            outputView.printNewLine();
        }
    }

}
