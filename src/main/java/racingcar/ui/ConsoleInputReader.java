package racingcar.ui;

import java.util.Scanner;

public class ConsoleInputReader {

    private final static Scanner SCANNER = new Scanner(System.in);

    private ConsoleInputReader() {

    }

    public static int readInt() {
        return SCANNER.nextInt();
    }

}
