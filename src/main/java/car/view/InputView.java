package car.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getNumberInput(InputType inputType) {
        System.out.println(inputType.getInputText());
        int input = SCANNER.nextInt();
        InputValidator.validatePositive(input, inputType);
        return input;
    }

    public static String[] getStringInput(InputType inputType) {
        System.out.println(inputType.getInputText());
        String[] input = SCANNER.nextLine().split(",");
        InputValidator.validateCarNameLengthInRange(input, inputType);
        return input;
    }
}
