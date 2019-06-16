package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.InputHandler;

import java.util.Scanner;

public class ConsoleIntegerInputHandler implements InputHandler<Integer> {
    private final Scanner scanner;

    public ConsoleIntegerInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Integer getInput() {
        return scanner.nextInt();
    }
}
