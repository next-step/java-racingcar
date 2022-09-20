package step3.application;

import java.util.Scanner;

public class ConsoleIn {
    private static final Scanner scanner = new Scanner(System.in);

    public int numberOfCars() {
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public int moveCount() {
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }
}
