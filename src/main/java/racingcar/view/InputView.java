package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import static racingcar.domain.ErrorMessage.IS_NOT_TRY_COUNT;

public class InputView {
    private static final String BASIC_DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt(Runnable messagePrinter) {
        try {
            messagePrinter.run();
            int count = SCANNER.nextInt();
            SCANNER.nextLine();
            return count;
        } catch (InputMismatchException ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        } catch (Exception ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        }
    }



    public static String[] inputCarList(Runnable messagePrinter) {
        messagePrinter.run();
        return SCANNER.nextLine().replace(SPACE, NO_SPACE).split(BASIC_DELIMITER);
    }
}
