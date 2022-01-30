package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.random.RandomGenerator;
import racinggame.view.InputView;
import racinggame.domain.Winners;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final String[] carNames = inputView.inputPlayerName();
        final Cars cars = new Cars(carNames);
        final RandomGenerator randomGenerator=new RandomGenerator();

        int playGameNumber = inputView.inputTryNumber();

        final ResultView resultView = new ResultView();
        for (; playGameNumber > 0; playGameNumber--) {
            cars.move(randomGenerator);
            resultView.captureResult(cars);

        }
        resultView.printCarsLocation();

        final int maxLocation = cars.findMaxLocation();
        final Winners winners = new Winners(cars, maxLocation);
        resultView.printWinner(winners);
    }

}
