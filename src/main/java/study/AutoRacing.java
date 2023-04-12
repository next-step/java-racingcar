package study;

import java.util.Scanner;

public class AutoRacing {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void StartRacing() {
        InputView.guidForInputNumberOfCar();
        int numberOfCar = SCANNER.nextInt();
        InputView.guideForInputNumberOfGame();
        int numberOfGame = SCANNER.nextInt();
    }

    public static void main(String[] args) {
        StartRacing();
    }
}
