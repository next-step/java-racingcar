package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static int getInput(String phraseToBeEntered) {

        System.out.println(phraseToBeEntered);
        Scanner scanner = new Scanner(System.in);

        return validateIntegerInput(scanner.nextLine());
    }

    public static int validateIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException i) {
            throw new IllegalArgumentException("Input should be number");
        }
    }

}
