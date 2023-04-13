package study.carrace.step3.presentation.util;

import study.carrace.step3.presentation.exception.IllegalCarQuantityException;
import study.carrace.step3.presentation.exception.IllegalIterationCountException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class ConsoleInputUtil {
    private static final String COMMA = ",";

    private ConsoleInputUtil() {
    }

    @Deprecated
    public static long askCarQuantity() {
        System.out.print(CAR_QUANTITY_QUESTION_MESSAGE.getMessage());
        long carQuantity = getLongFromConsole();
        validateCarQuantity(carQuantity);

        return carQuantity;
    }

    public static long askIterationCount() {
        System.out.print(ITERATION_COUNT_QUESTION_MESSAGE.getMessage());
        long iterationCount = getLongFromConsole();
        validateIterationCount(iterationCount);

        return iterationCount;
    }

    public static List<String> askCarNames() {
        System.out.println(RACE_CAR_NAMES_QUESTION_MESSAGE.getMessage());
        return splitCSVToList(getStringFromConsole());
    }

    private static List<String> splitCSVToList(String csvString) {
        return Arrays.asList(csvString.split(COMMA));
    }

    private static String getStringFromConsole() {
        return new Scanner(System.in).nextLine();
    }

    private static long getLongFromConsole() {
        return new Scanner(System.in).nextLong();
    }

    private static void validateIterationCount(long iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }

    private static void validateCarQuantity(long carQuantity) {
        if (carQuantity <= 0) {
            throw new IllegalCarQuantityException(carQuantity);
        }
    }
}
