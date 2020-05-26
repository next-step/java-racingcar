package step4;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static final String QUESTION_CARS_NAMES = "What are cars names into this game? : ";
    private static final String QUESTION_TRY_COUNT = "How many times try this game? : ";

    private static final String INPUT_NAMES_DELIMITER = ",";

    public static String[] setCarsNames() {
        // input
        System.out.println(QUESTION_CARS_NAMES);
        String[] carNames = inputStringArray();
        return carNames;
    }

    public static int setPlayCounts() {
        // input
        System.out.println(QUESTION_TRY_COUNT);
        int result = inputIntNumber();
        return result;
    }

    private static String[] inputStringArray() {
        String result = scanner.next();
        return result.split(INPUT_NAMES_DELIMITER);
    }

    private static int inputIntNumber() {
        int result = scanner.nextInt();
        return result;
    }

}
