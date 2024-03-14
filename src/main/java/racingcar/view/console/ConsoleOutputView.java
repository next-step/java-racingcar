package racingcar.view.console;

import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printOneLine(final String text) {
        System.out.println(text);
    }

    @Override
    public void printCarCountInputMessage() {
        printOneLine(CAR_COUNT_INPUT_MESSAGE);
    }

    @Override
    public void printPlayingCountInputMessage() {
        printOneLine(PLAYING_COUNT_INPUT_MESSAGE);
    }
}
