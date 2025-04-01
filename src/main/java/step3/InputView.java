package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("차 대수:" + carCount);

        return carCount;
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();
        System.out.println("이동 횟수:" + moveCount);

        return moveCount;
    }
}
