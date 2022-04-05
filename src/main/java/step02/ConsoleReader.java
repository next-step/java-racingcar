package step02;

import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

}
