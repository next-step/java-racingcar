package game;

import java.util.List;

public class gameMain {
    public static void main(String[] args) {
        int numberofCars = InputView.getNumberofCars();
        int numberofAttempts = InputView.getNumberofAttempts();

        RacingGame racingGame = new RacingGame(numberofCars, numberofAttempts);
        for(int i = 1; i <= numberofAttempts; i++){
            List<Car> cars = racingGame.playGame(i);
            OutputView.print(cars);
        }

    }
}
