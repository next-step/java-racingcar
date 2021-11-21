package study.step_3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int numberOfCars() {
        return scanner.nextInt();
    }

    public static int numberOfTrial() {
        return scanner.nextInt();
    }
}
