package racingcar;

import java.util.Scanner;

public class ConsoleInputReader {

    private final static Scanner scanner = new Scanner(System.in);

    private ConsoleInputReader() {

    }

    public static int readInt() {
        return scanner.nextInt();
    }

}
