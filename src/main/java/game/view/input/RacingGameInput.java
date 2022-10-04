package game.view.input;

import game.view.output.InputView;

import java.util.List;

public class RacingGameInput {

    public static int inputNumberOfCar() {
        InputView.printInputCarGuide();
        return Input.inputPositiveNumber();
    }

    public static List<String> inputCarNames() {
        InputView.printInputNameGuide();
        return Input.inputNames();
    }

    public static int inputNumberOfRound() {
        InputView.printInputRoundGuide();
        return Input.inputPositiveNumber();
    }

}
