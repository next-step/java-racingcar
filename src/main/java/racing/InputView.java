package racing;

import java.util.Scanner;

public class InputView {

    private static int manyCars = 0;
    private static int tryCount = 0;
    private static final String numberRegex = "^[0-9]*$";

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf(InputViewMessage.FIRST_QUESTION);
            manyCars = validationCheck(scanner.next());
        } while (manyCars <= 0);

        do {
            System.out.printf(InputViewMessage.SECOND_QUESTION);
            tryCount = validationCheck(scanner.next());
        } while (tryCount <= 0);

        scanner.close();
    }

    public int validationCheck(String input) {
        if(!input.matches(numberRegex)) {
            System.out.printf(InputViewMessage.INPUT_FORMAT_VALIDATION_ERROR);
            return 0;
        }
        System.out.printf(InputViewMessage.INPUT_VALIDATION_ERROR);
        return Integer.valueOf(input);
    }

    public int getManyCars() {
        return manyCars;
    }

    public int getTryCount() {
        return tryCount;
    }

}
