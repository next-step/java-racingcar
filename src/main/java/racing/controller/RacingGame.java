package racing.controller;

import racing.msg.SystemMention;
import racing.domain.Cars;
import racing.view.UserInput;

public class RacingGame {

    public static void runGame() {
        UserInput userInput = new UserInput();
        SystemMention.CNT_OF_CAR.printMention();
        int cntOfCar = userInput.inputCntOfCar();
        SystemMention.CNT_OF_TRY.printMention();
        int cntOfTry = userInput.inputCntOfCar();

        Cars cars = new Cars(cntOfCar, cntOfTry);
        cars.tryMove();
    }

    public static void main(String[] args) {
        RacingGame.runGame();
    }
}
