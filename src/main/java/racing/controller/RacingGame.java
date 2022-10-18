package racing.controller;

import racing.msg.SystemMention;
import racing.domain.Cars;
import racing.view.UserInput;

public class RacingGame {

    public static void runGame() {
        UserInput userInput = new UserInput();
        String[] names = inputNames(userInput);
        Cars cars = new Cars(names);
        int cntOfTry = inputCntOfCar(userInput);

        SystemMention.RESULT.printMention();
        String winners = Racing.raceResult(cars, cntOfTry);
        SystemMention.SUFFIX_WINNER.printMention(winners);
    }

    private static String[] inputNames(UserInput userInput) {
        SystemMention.CNT_OF_CAR.printMention();
        return userInput.inputNames();
    }

    private static int inputCntOfCar(UserInput userInput) {
        SystemMention.CNT_OF_TRY.printMention();
        return userInput.inputCntOfCar();
    }

    public static void main(String[] args) {
        RacingGame.runGame();
    }
}
