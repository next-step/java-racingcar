package study.carrace.step3.presentation.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class ConsoleInputUtil {
    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInputUtil() {
    }

    public static int askIterationCount() {
        System.out.print(ITERATION_COUNT_QUESTION_MESSAGE.getMessage());
        return getIntFromConsole();
    }

    public static List<String> askCarNames() {
        System.out.println(RACE_CAR_NAMES_QUESTION_MESSAGE.getMessage());
        return splitCSVToList(getStringFromConsole());
    }

    private static List<String> splitCSVToList(String csvString) {
        return Arrays.asList(csvString.split(COMMA));
    }

    private static String getStringFromConsole() {
        return SCANNER.nextLine();
    }

    private static int getIntFromConsole() {
        return SCANNER.nextInt();
    }
}
