package game;

import java.util.List;

public class GameMain {
    public static void main(String[] args) {
        int numberofCars = InputView.getNumberofCars();
        int numberofAttempts = InputView.getNumberofAttempts();

        RacingGame racingGame = new RacingGame(numberofCars);
        for(int i = 0; i < numberofAttempts; i++){
            List<Car> cars = racingGame.playGame();
            OutputView.print(cars);
        }
    }
}
