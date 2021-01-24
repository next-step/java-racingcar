package racingcar;

import racingcar.view.*;

public class ApplicationContext {

    private final Input input;
    private final Output output;

    public ApplicationContext() {
        this.input = new KeyboardInput(System.in);
        this.output = new ConsoleOutput();
    }

    public IOManager getIOManager() {
        return new IOManager(input, output);
    }
}
