package racingcar.view.io.console;

import java.util.Scanner;

import racingcar.view.io.Input;

public class ConsoleInput implements Input {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String readOneLine() {
        return scanner.nextLine();
    }
}
