package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.service.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputValues();

        RacingGame race = new RacingGame();
        List<Car> carList = race.setCars(inputView.howManyCars());
        Cars cars = new Cars(carList);

        ResultView resultView = new ResultView();

        for (int i = 0; i < inputView.getAttemps(); i++) {
            race.play(cars, i);
            resultView.printResult(cars, i);
        }
    }
}
