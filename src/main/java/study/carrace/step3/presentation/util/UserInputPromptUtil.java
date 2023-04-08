package study.carrace.step3.presentation.util;

import java.util.Scanner;

import static study.carrace.step3.presentation.PromptMessage.*;

public class UserInputPromptUtil {
    private UserInputPromptUtil() { }

    public static int askQuantityOfCars() {
        System.out.print(CAR_QUANTITY_QUESTION_MESSAGE.getMessage());
        int carQuantity = new Scanner(System.in).nextInt();
        validateCarQuantity(carQuantity);

        return carQuantity;
    }

    private static void validateCarQuantity(int carQuantity) {
        if(carQuantity <= 0) {
            throw new IllegalArgumentException("자동차 대수는 한 대 이상이여야 합니다: " + carQuantity);
        }
    }
}
