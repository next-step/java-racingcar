package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.service.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputView.inputValues();

        RacingGame race = new RacingGame(InputView.howManyCars(), InputView.getAttemps());
        List<Car> carList = race.setCars();
        Cars cars = new Cars(carList);

        for (int i = 0; i < InputView.getAttemps(); i++) {
            race.play(cars);
            ResultView.printResult(cars, i);
        }
    }
}
