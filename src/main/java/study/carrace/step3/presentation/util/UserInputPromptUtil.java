package study.carrace.step3.presentation.util;

import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class UserInputPromptUtil {
    private UserInputPromptUtil() {
    }

    public static int askQuantityOfCars() {
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
            throw new IllegalArgumentException("시도 횟수는 한번 이상이여야 합니다: " + iterationCount);
        }
    }

    private static void validateCarQuantity(int carQuantity) {
        if (carQuantity <= 0) {
            throw new IllegalArgumentException("자동차 대수는 한 대 이상이여야 합니다: " + carQuantity);
        }
    }
}
