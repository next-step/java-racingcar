package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] questions = new String[] {
            "자동차 대수는 몇 대 인가요?",
            "시도할 회수는 몇 회 인가요?"
    };

    public static int[] input() {
        int[] inputResult = new int[questions.length];

        for (int i=0; i<questions.length; i++) {
            System.out.println(questions[i]);
            inputResult[i] = scanner.nextInt();
        }

        return inputResult;
    }
}
