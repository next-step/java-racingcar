package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int getNumberInput(String phraseToBeEntered) {

        System.out.println(phraseToBeEntered);

        return validateIntegerInput(scanner.nextLine());
    }

    public static String getInput(String phraseToBeEntered) {

        System.out.println(phraseToBeEntered);

        return scanner.nextLine();
    }

    private static int validateIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException i) {
            throw new IllegalArgumentException("Input should be number");
        }
    }

}
