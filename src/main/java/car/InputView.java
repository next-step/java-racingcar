package car;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInput(InputType inputType) {
        System.out.println(inputType.getInputText());
        int input = SCANNER.nextInt();
        InputValidator.validatePositive(input, inputType);
        return input;
    }
}
