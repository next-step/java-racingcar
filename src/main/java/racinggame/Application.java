package racinggame;

import racinggame.domain.AllRoundHistory;
import racinggame.domain.car.Cars;
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
        final AllRoundHistory allRoundHistory=new AllRoundHistory();
        final ResultView resultView = new ResultView();
        for (; playGameNumber > 0; playGameNumber--) {
            cars.move(randomGenerator);
            allRoundHistory.captureRoundHistory(cars);

        }
        resultView.printCarsLocation(allRoundHistory.getAllRoundHistory());

        final int maxLocation = cars.findMaxLocation();
        final Winners winners = new Winners(cars, maxLocation);
        resultView.printWinner(winners);
    }

}
