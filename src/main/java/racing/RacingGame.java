package racing;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        inputView.runUserInput();

        String[] names = inputView.getNames();
        Valid.checkEmptyOrBlank(names);

        inputView.runTimeInput();
        int inputTime = inputView.getInputTime();
        Valid.timeGreaterThenZero(inputTime);

        Cars initCars = new Cars(names);
        OutputView outputView = new OutputView();
        Dice dice = new DiceWithRandom();

        for (int time = 0; time < inputTime; time++) {
            initCars.playGame(dice);
            outputView.resultPrint(initCars.getCars());
        }
        outputView.printWinner(initCars.getWinner());
    }


}
