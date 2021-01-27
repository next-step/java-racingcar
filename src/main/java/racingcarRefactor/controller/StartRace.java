package racingcarRefactor.controller;

import racingcarRefactor.domain.Car;
import racingcarRefactor.domain.CarValidator;
import racingcarRefactor.domain.Game;
import racingcarRefactor.domain.GenerateCar;
import racingcarRefactor.view.InputView;
import racingcarRefactor.view.ResultView;

import java.util.List;

public class StartRace {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        CarValidator.carNameChecker(carNames);
        int laps = InputView.inputTotalLaps();
        List<Car> cars = GenerateCar.ofCars(carNames);

        Game game = new Game();
        for (int i = 0; i < laps; i++) {
            game.round(cars);
            doRace(cars);
        }

        ResultView.displayWinner(game.getWinners(cars));
    }

    public static void doRace(List<Car> cars) {
        for (Car car : cars) {
            ResultView.displayRound(car.getName(), car.getPosition());
        }
        ResultView.endOfRound();
    }
}
