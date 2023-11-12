package racingcar;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String[] questions = new String[] {
            "자동차 대수는 몇 대 인가요?",
            "시도할 회수는 몇 회 인가요?"
    };
    private int carNumber;
    private int roundNumber;

    private static String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";

    public void input() {
        // car Number
        System.out.println(questions[0]);
        carNumber = scanner.nextInt();

        // round Number
        System.out.println(questions[1]);
        roundNumber = scanner.nextInt();

        validateInput(new int[] {carNumber, roundNumber});
    }

    public static void validateInput(int[] inputValues) {
        for (int i : inputValues) {
            if (i < 0) {
                throw new RuntimeException(ERR_NEGATIVE_NUMBER);
            }
        }
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }
}
