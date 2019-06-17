package racingcar.view.input;

import java.util.Scanner;

public class NumberInputReader {
    private Scanner scanner = new Scanner(System.in);

    public Integer get() {
        return scanner.nextInt();
    }
}
