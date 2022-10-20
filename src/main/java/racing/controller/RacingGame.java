package racing.controller;

import racing.msg.SystemMention;
import racing.view.UserInput;
import racing.domain.Car;

import java.util.List;

public class RacingGame {

    public static void runGame() {
        UserInput userInput = new UserInput();
        List<Car> carList = userInput.inputCarList();
        int cntOfTry = userInput.inputCntOfTry();

        SystemMention.RESULT.printMention();
        Racing racing = new Racing(carList, cntOfTry);
        String winners = racing.raceResultStr();
        SystemMention.SUFFIX_WINNER.printMention(winners);
    }

    public static void main(String[] args) {
        RacingGame.runGame();
    }
}
