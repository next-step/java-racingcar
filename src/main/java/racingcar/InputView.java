package racingcar;


import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String BASIC_DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt(Runnable messagePrinter) {
        int count = 0;
        boolean isValid = false;
        while (!isValid) {
            messagePrinter.run();
            try {
                count = SCANNER.nextInt();
                isValid = isPositiveNum(count);
            } catch (InputMismatchException ex) {
                SCANNER.next();
            }
        }
        return count;
    }

    public static boolean isPositiveNum(int num) {
        return num > 0;
    }

    public static String[] inputCarList(Runnable messagePrinter) {
        messagePrinter.run();
        return SCANNER.nextLine().replace(SPACE, NO_SPACE).split(BASIC_DELIMITER);
    }
}
