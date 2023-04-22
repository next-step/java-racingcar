package racingcar;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String inputString() {
        return scanner.nextLine();
    }

    public int inputInt() {
        return scanner.nextInt();
    }
}
