package game;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {
        String nameofCars = InputView.getNumberofCars();
        int numberofAttempts = InputView.getNumberofAttempts();
        List<Car> cars = null;

        RacingGame racingGame = new RacingGame(nameofCars);
        for (int i = 0; i < numberofAttempts; i++) {
            cars = racingGame.playGame();
            OutputView.print(cars);
        }

        String winners = Winners.findWinners(cars);
        OutputView.printWinners(winners);
    }
}


