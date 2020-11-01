package racingcar;

import racingcar.inputview.ConsoleInputDevice;
import racingcar.inputview.ConsoleInputView;
import racingcar.inputview.InputHandler;
import racingcar.resultview.ConsoleResultView;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new ConsoleInputView(), new ConsoleInputDevice());
        RacingCarGame racingCarGame = new RacingCarGame(inputHandler, new ConsoleResultView());
        racingCarGame.start();
    }
}
