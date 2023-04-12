package study.carrace.step3.presentation.util;

import study.carrace.step3.presentation.exception.IllegalCarNameException;
import study.carrace.step3.presentation.exception.IllegalCarQuantityException;
import study.carrace.step3.presentation.exception.IllegalIterationCountException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class ConsoleInputUtil {
    private static final String COMMA = ",";
    private static final int CAR_NAME_LENGTH_THRESHOLD = 5;

    private ConsoleInputUtil() {
    }

    @Deprecated
    public static int askCarQuantity() {
        System.out.print(CAR_QUANTITY_QUESTION_MESSAGE.getMessage());
        int carQuantity = getIntFromConsole();
        validateCarQuantity(carQuantity);

        return carQuantity;
    }

    public static int askIterationCount() {
        System.out.print(ITERATION_COUNT_QUESTION_MESSAGE.getMessage());
        int iterationCount = getIntFromConsole();
        validateIterationCount(iterationCount);

        return iterationCount;
    }

    public static List<String> askCarNames() {
        System.out.println(RACE_CAR_NAMES_QUESTION_MESSAGE.getMessage());
        List<String> carNames = splitCSVToList(getStringFromConsole());
        validateCarNames(carNames);

        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        findCarWithNameLongerThanThreshold(carNames)
                .ifPresent(carName -> {
                    throw new IllegalCarNameException(carName);
                });
    }

    private static Optional<String> findCarWithNameLongerThanThreshold(List<String> carNames) {
        return carNames.stream()
                .filter(carName -> carName.length() > CAR_NAME_LENGTH_THRESHOLD)
                .findFirst();
    }

    private static List<String> splitCSVToList(String csvString) {
        return Arrays.asList(csvString.split(COMMA));
    }

    private static String getStringFromConsole() {
        return new Scanner(System.in).nextLine();
    }

    private static int getIntFromConsole() {
        return new Scanner(System.in).nextInt();
    }

    private static void validateIterationCount(int iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }

    private static void validateCarQuantity(int carQuantity) {
        if (carQuantity <= 0) {
            throw new IllegalCarQuantityException(carQuantity);
        }
    }
}
