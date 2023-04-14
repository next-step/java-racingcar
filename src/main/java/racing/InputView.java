package racing;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static int carCount;
    private static int moveCount;

    public static void input() {
        System.out.println("자동차 수를 입력하세요: ");
        carCount = scanner.nextInt();
        System.out.println("이동 횟수를 입력하세요: ");
        moveCount = scanner.nextInt();
    }

    public static int getCarCount() {
        return carCount;
    }

    public static int getMoveCount() {
        return moveCount;
    }

}
