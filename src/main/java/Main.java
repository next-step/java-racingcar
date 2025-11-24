import model.CarRacingGame;
import model.Cars;
import ui.GameUI;
import ui.InputView;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        CarRacingGame carRacingGame = new CarRacingGame();
        Cars cars = new Cars(carNames);

        carRacingGame.race(tryCount, cars.getCars());

        List<String> winnerNames = carRacingGame.findWinner(cars.getCars());
        GameUI.printWinners(winnerNames);
    }
}
