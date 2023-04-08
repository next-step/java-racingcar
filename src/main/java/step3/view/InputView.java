package step3.view;

import java.util.Scanner;

import static step3.component.NumberValidator.validateCarAmount;
import static step3.component.NumberValidator.validateTryNumber;

public class InputView {
    private static final String inputCarNumberMessage = "자동차 대수는 몇 대 인가요?";
    private static final String inputTryNumberMessage = "시도할 회수는 몇 회 인가요?";

    public static int inputCarNumbers(Scanner scanner) {
        System.out.println(inputCarNumberMessage);
        return validateCarAmount(scanner.nextInt());
    }

    public static int inputTryNumbers(Scanner scanner) {
        System.out.println(inputTryNumberMessage);
        return validateTryNumber(scanner.nextInt());
    }
}
