package step4;

import java.util.Scanner;

/*
 * Java Racing Game
 * InputView
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class InputView {


    private static final String QUESTION_CARS_NAMES = "What are cars names into this game? : ";
    private static final String QUESTION_PLAY_TIMES = "How many times try this game? : ";
    private static final String INPUT_NAMES_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] setCarsNames() {
        // input
        System.out.println(QUESTION_CARS_NAMES);
        String[] carNames = inputStringArray();
        return carNames;
    }

    public static int setPlayTimes() {
        // input
        System.out.println(QUESTION_PLAY_TIMES);
        int playTimes = inputIntNumber();
        return playTimes;
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
