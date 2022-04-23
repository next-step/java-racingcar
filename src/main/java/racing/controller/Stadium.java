package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.domain.RandomRule;
import racing.domain.Rule;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Stadium {

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = InputView.inputNumberOfCars();
        final NumberOfRound numberOfRound = InputView.inputNumberOfRound();
        final Rule rule = new RandomRule();

        Game game = new Game(numberOfRound, rule);
        final List<Car> cars = game.equipRacingCar(numberOfCars);
        while (game.isLeftRound()) {
            game.proceedRound();
            ResultView.print(cars);
        }
    }
}
