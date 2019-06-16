package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.InputHandler;

import java.util.Scanner;

public class ConsoleIntegerInputHandler implements InputHandler<Integer> {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public Integer getInput() {
        return SCANNER.nextInt();
    }
}
