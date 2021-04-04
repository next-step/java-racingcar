package RacingGame;

import java.util.List;

public class Main {

    public static void main(String[] args){

        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        String[] nameOfCars = inputView.inputNameOfCars();
        racingGame.getInputValue(nameOfCars);
        racingGame.prepareGame();

        int numOfTry = inputView.inputNumOfTry();
        for (int i = 0; i < numOfTry; i++){
            List<Car> cars = racingGame.playGame();
            ResultView.viewGame(cars);
        }

        List<String> winners = racingGame.getWinners();
        ResultView.viewWinner(winners);


    }
}
