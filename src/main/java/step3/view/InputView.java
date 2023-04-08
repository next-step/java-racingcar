package step3.view;

import java.util.Scanner;

public class InputView {
    private static final String inputCarNumberMessage = "자동차 대수는 몇 대 인가요?";
    private static final String inputTryNumberMessage = "시도할 회수는 몇 회 인가요?";

    public static String inputCarNumbers(Scanner scanner) {
        System.out.println(inputCarNumberMessage);
        return scanner.nextLine();
    }

    public static String inputTryNumbers(Scanner scanner) {
        System.out.println(inputTryNumberMessage);
        return scanner.nextLine();
    }
}
