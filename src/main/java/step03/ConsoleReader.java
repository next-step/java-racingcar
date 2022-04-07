package step03;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public int readNumber() {
        return scanner.nextInt();
    }

}
