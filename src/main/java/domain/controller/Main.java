package domain.controller;

import domain.car.Car;
import domain.car.CarRacingGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        List<Car> cars = inputView.carNameQuestion();
        int attemptCount = inputView.attemptCountQuestion();

        CarRacingGame racing = new CarRacingGame(cars);
        racing.start(attemptCount);

        ResultView resultView = new ResultView(racing);
        List<Car> finish = racing.finish();
        resultView.print(finish);
    }
}
