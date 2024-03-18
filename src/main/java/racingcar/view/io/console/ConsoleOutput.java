package racingcar.view.io.console;

import racingcar.view.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printOneLine(final String text) {
        System.out.println(text);
    }
}
