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
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));

        ArrayList<String> carNames = Utility.nameStringToArray(inputHandler.getCarName());

        if (!NameValidator.checkCarName(carNames)) {
            OutputHandler.exitMessage();
            System.exit(0);
        }

        int laps = inputHandler.getLaps();

        List<Car> cars = CarGenerator.generateCars(carNames);

        Game game = new Game();
        for(int i = 0; i < laps; i++) {
            game.proceedRound(cars);
            OutputHandler.displayDash(cars);
        }

        OutputHandler.racingResult(game.getWinners(cars));
    }

}
