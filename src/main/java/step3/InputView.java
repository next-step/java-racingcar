package step3;


import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static int inputInt(Runnable messagePrinter) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean isValid = false;
        while (!isValid) {
            messagePrinter.run();
            try {
                count = scanner.nextInt();
                isValid = isPositiveNum(count);
            } catch (InputMismatchException ex) {
                scanner.next();
            }
        }
        return count;
    }

    public static boolean isPositiveNum(int num) {
        return num > 0;
    }
}
