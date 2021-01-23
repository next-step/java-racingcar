package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.Game;
import racingcar.domain.NameValidator;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));

        ArrayList<String> carNames = inputHandler.getCarName();
        Boolean startGame = NameValidator.checkCarName(carNames);

        if (!startGame) {
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
