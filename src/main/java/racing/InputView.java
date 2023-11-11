package racing;

import java.util.Scanner;

public class InputView {
    private static final int INPUT_THRESHOLD = 2;

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요? (2 이상의 자연수 입력)");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        validateInput(carCount);

        return carCount;
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요? (2 이상의 자연수 입력)");
        Scanner scanner = new Scanner(System.in);
        int moveCount = scanner.nextInt();
        validateInput(moveCount);

        return moveCount;
    }

    public static void validateInput(int input) {
        if (input < INPUT_THRESHOLD) {
            throw new IllegalArgumentException("PLEASE INPUT APPROPRIATE NUMBER (OVER 1)");
        }
    }
}
