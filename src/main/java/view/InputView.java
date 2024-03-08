package view;

import java.util.Scanner;

public class InputView {

    public int inputRacingCarNumber() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputTryNumber() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
