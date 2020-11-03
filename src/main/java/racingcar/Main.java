package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.view.inputview.ConsoleInputDevice;
import racingcar.view.inputview.ConsoleInputView;
import racingcar.view.inputview.InputHandler;
import racingcar.view.resultview.ConsoleResultView;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new ConsoleInputView(), new ConsoleInputDevice());
        RacingCarGame racingCarGame = new RacingCarGame(inputHandler, new ConsoleResultView());
        racingCarGame.start();
    }
}
