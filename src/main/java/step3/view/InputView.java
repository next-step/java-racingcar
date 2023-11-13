package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        System.out.println(QUESTION_CAR_COUNT);
        return scanner.nextInt();
    }

    public static int inputRoundCount() {
        System.out.println(QUESTION_ROUND_COUNT);
        return scanner.nextInt();
    }
}
