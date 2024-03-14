package racingcar.view.console;

import java.util.Scanner;

import racingcar.view.InputView;

public class ConsoleInputView implements InputView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String readOneLine() {
        return scanner.nextLine();
    }
}
