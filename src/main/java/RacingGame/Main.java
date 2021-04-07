package RacingGame;

import RacingGame.domain.Car;
import RacingGame.domain.Cars;
import RacingGame.view.InputView;
import RacingGame.view.ResultView;

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
            racingGame.playGame();
            ResultView.viewGame(racingGame.getCarDtos());
        }

        List<String> winners = racingGame.getWinners();
        ResultView.viewWinner(winners);


    }
}
