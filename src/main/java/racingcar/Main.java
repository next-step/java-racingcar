package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.Game;
import racingcar.controller.NameValidator;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;
import racingcar.controller.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> carNames = Utility.convertNameStringToArray(InputHandler.getCarName());
        if (!NameValidator.checkCarName(carNames)) {
            OutputHandler.exitMessage();
            System.exit(0);
        }

        List<Car> cars = CarGenerator.generateCars(carNames);

        Game game = new Game();
        int laps = InputHandler.getLaps();
        for(int i = 0; i < laps; i++) {
            game.proceedRound(cars);
            OutputHandler.displayDash(cars);
        }
        OutputHandler.racingResult(game.getWinners(cars));
    }

}
