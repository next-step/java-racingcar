package racingCar.controller;

import racingCar.domain.Cars;
import racingCar.domain.NumberOfGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;


public class RacingGame {
    public void startGame() {
        String[] nameList = InputView.nameList();
        int carOfNumber = nameList.length;
        Cars cars = new Cars(nameList);
        NumberOfGame numberOfGame = new NumberOfGame(InputView.numberOfGame());

        System.out.println("\n실행 결과");
        while (!numberOfGame.isEndGame()) {
            ResultView.resultOfCars(cars, carOfNumber);
            numberOfGame.decreaseNumberOfGame();
        }
        ResultView.resultOfWinners(cars);
    }
}
