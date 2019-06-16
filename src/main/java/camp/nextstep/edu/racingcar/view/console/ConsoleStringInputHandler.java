package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.InputHandler;

import java.util.Scanner;

public class ConsoleStringInputHandler implements InputHandler<String> {
    private final Scanner scanner;

    public ConsoleStringInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
