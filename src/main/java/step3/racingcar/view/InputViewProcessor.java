package step3.racingcar.view;

import java.util.Scanner;

public class InputViewProcessor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private InputViewProcessor() {
    }

    public static String[] getCarNames(String instructionMessage) {
        System.out.println(instructionMessage);
        String[] carNames = scanner.next().split(SEPARATOR);
        return carNames;
    }

    public static int getGameTryCounts(String instructionMessage) {
        System.out.println(instructionMessage);
        int userInput = scanner.nextInt();
        return userInput;
    }
}
