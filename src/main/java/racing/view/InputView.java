package racing.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumberOfCar() {
        return scanner.nextInt();
    }

    public static int getNumberOfRound() {
        return scanner.nextInt();
    }
}
