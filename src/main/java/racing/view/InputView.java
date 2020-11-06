package racing.view;

import java.util.Scanner;
import static racing.view.InputViewMessage.*;

public class InputView {

    private static final String numberRegex = "^[0-9]*$";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getManyCars() {
        int manyCars;
        do {
            System.out.print(FIRST_QUESTION);
        } while ((manyCars = inputValidationCheck(scanner.next())) <= 0);
        return manyCars;
    }

    public static int getLabs() {
        int labs;
        do {
            System.out.print(SECOND_QUESTION);
        } while ((labs = inputValidationCheck(scanner.next())) <= 0 );
        return labs;
    }

    private static int inputValidationCheck(String input) {
        if(numberFormatCheck(input) == 0) {
            return 0;
        }
        return minimumValueCheck(input);
    }

    private static int minimumValueCheck(String input) {
        int value = Integer.parseInt(input);
        if(value <= 0)
            System.out.print(INPUT_VALIDATION_ERROR);

        return value;
    }

    private static int numberFormatCheck(String input) {
        if(!input.matches(numberRegex)) {
            System.out.print(INPUT_FORMAT_VALIDATION_ERROR);
            return 0;
        }
        return minimumValueCheck(input);
    }

}
