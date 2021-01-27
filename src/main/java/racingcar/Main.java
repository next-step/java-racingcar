package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputHandler ip = new InputHandler();

        ArrayList<String> carNames = ip.inputCarName();
        Boolean startGame = ip.carNameChecker(carNames);
        if (!startGame) {
            OutputHandler.exitMessage();
            System.exit(0);
        }

        int laps = ip.inputLaps();
        List<Car> cars = GenerateCar.ofCars(ip.getCarNameStr());
        Game game = new Game();
        for(int i=0; i<laps; i++) {
            game.round(cars);
            OutputHandler.displayDash(cars);
        }

        OutputHandler.racingResult(game.getWinners(cars));
    }

}
