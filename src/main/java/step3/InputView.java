package step3;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static final String QUESTION_CARS_COUNT = "How many cars into this game? : ";
    private static final String QUESTION_TRY_COUNT = "How many times try this game? : ";

    public static int setCarsCount() {
        // input
        System.out.println(QUESTION_CARS_COUNT);
        int result = inputIntNumber();
        return result;
    }

    public static int setPlayCounts() {
        // input
        System.out.println(QUESTION_TRY_COUNT);
        int result = inputIntNumber();
        return result;
    }

    private static int inputIntNumber() {
        int result = scanner.nextInt();
        return result;
    }

}
