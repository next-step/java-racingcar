package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_HOW_MANY_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_HOW_MANY_ROUND = "시도할 회수는 몇 회 인가요?";
    public static int inputCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public static int inputGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_HOW_MANY_ROUND);
        return scanner.nextInt();
    }
}
