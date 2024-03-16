package race.domain;

import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<Car> carList = new CarFactory().createCars(inputView.inputCar());
        int tryCount = inputView.inputTry();

        resultView.showWinners(new Winner().findWinner(new RacingGame().race(carList, tryCount)));
    }
}
