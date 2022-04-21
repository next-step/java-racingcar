package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Stadium {

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = InputView.inputNumberOfCars();
        final NumberOfRound numberOfRound = InputView.inputNumberOfRound();

        Game game = new Game(numberOfRound);
        final List<Car> cars = game.equipRacingCar(numberOfCars);
        while (game.isLeftRound()) {
            game.proceedRound();
            ResultView.print(cars);
        }
    }
}
