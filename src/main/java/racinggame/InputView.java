package racinggame;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static int readCarCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
