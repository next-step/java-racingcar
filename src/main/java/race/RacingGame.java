package race;

import race.domain.Cars;
import race.utils.RandomStrategy;
import race.view.InputView;
import race.view.OutputView;

import java.util.List;

public class RacingGame {

    private static final String STANDARD_SPLIT_REGEX = ",";
    private final OutputView outputView;
    private final InputView inputView;

    public RacingGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        String nameOfCar = inputView.askNameOfCar();
        String[] names = nameOfCar.split(STANDARD_SPLIT_REGEX);
        int carNumbers = names.length;
        int attempts = inputView.askNumberOfAttempts();

        outputView.printResultStatement();

        Cars cars = new Cars(carNumbers, names);
        for (int attempt = 0; attempt < attempts; attempt++) {
            List<Integer> points = cars.goForward(new RandomStrategy());
            outputView.printMileages(points);
            outputView.printNewLine();
        }
    }

}
