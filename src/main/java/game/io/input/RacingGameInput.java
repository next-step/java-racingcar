package game.io.input;

import game.io.output.InputView;

public class RacingGameInput {

    public static int inputNumberOfCar() {
        InputView.printInputCarGuide();
        return Input.inputPositiveNumber();
    }

    public static int inputNumberOfRound() {
        InputView.printInputRoundGuide();
        return Input.inputPositiveNumber();
    }

}
