package racingcar.view.console;

import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printOneLine(final String text) {
        System.out.println(text);
    }
}
