package study.carrace.step3.presentation.util;

import study.carrace.step3.presentation.exception.IllegalCarQuantityException;
import study.carrace.step3.presentation.exception.IllegalIterationCountException;

import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class ConsoleInputUtil {
    private ConsoleInputUtil() {
    }

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
