package racingcar;

import racingcar.controller.GameController;
import racingcar.view.ConsoleOutput;
import racingcar.view.Input;
import racingcar.view.KeyboardInput;
import racingcar.view.Output;

public class ApplicationContext {

    private final Input input;
    private final Output output;

    public ApplicationContext() {
        this.input = new KeyboardInput(System.in);
        this.output = new ConsoleOutput();
    }

    public GameController getGameController() {
        Input input = new KeyboardInput(System.in);
        Output output = new ConsoleOutput();
        return new GameController(input, output);
    }
}
