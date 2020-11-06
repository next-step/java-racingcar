package racing.view;

import java.util.Scanner;

public class InputView {

    private static int manyCars = 0;
    private static int tryCount = 0;
    private static final String numberRegex = "^[0-9]*$";

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(InputViewMessage.FIRST_QUESTION);
            manyCars = inputValidationCheck(scanner.next());
        } while (manyCars <= 0);

        do {
            System.out.print(InputViewMessage.SECOND_QUESTION);
            tryCount = inputValidationCheck(scanner.next());
        } while (tryCount <= 0 );

        scanner.close();
    }

    private int inputValidationCheck(String input) {
        if(numberFormatCheck(input) == 0) {
            return 0;
        }
        return minimumValueCheck(input);
    }

    private int minimumValueCheck(String input) {
        int value = Integer.parseInt(input);
        if(value <= 0)
            System.out.print(InputViewMessage.INPUT_VALIDATION_ERROR);

        return value;
    }

    private int numberFormatCheck(String input) {
        if(!input.matches(numberRegex)) {
            System.out.print(InputViewMessage.INPUT_FORMAT_VALIDATION_ERROR);
            return 0;
        }
        return minimumValueCheck(input);
    }

    public static int getManyCars() {
        return manyCars;
    }

    public static int getTryCount() {
        return tryCount;
    }

}
