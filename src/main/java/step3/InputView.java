package step3;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int setCarsCount() {
        // input
        System.out.println("How many cars into this game? : ");
        int result = inputIntNumber();
        return result;
    }

    public static int setPlayCounts() {
        // input
        System.out.println("How many times try this game? : ");
        int result = inputIntNumber();
        return result;
    }

    private static int inputIntNumber() {
        int result = scanner.nextInt();
        inputCheck(result);
        return result;
    }

    public static int inputCheck(int result) {
        if (result < 0) throw new IllegalArgumentException("It can't be negative number.");
        return result;
    }

}
