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

        Game game = new Game();
        final List<Car> cars = game.equipRacingCar(numberOfCars);
        for (int i = 0; i < numberOfRound.number; i++) {
            game.proceedRound();
            ResultView.print(cars);
        }
    }
}
