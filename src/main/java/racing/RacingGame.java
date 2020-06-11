package racing;

import racing.domain.Cars;
import racing.utils.Dice;
import racing.utils.DiceWithRandom;
import racing.utils.InputValid;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        inputView.runUserInput();
        inputView.runTimeInput();

        int inputTime = inputView.getInputTime();

        InputValid.timeGreaterThenZero(inputTime);

        Cars initCars = new Cars(inputView.getNames());
        Dice dice = new DiceWithRandom();
        OutputView outputView = new OutputView();

        for (int time = 0; time < inputTime; time++) {
            initCars.playGame(dice);
            outputView.resultPrint(initCars.getCars());
        }

        outputView.printWinner(initCars.getWinner());
    }


}
