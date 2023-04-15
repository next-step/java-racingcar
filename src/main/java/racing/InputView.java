package racing;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static int carCount;
    private static int moveCount;

    public static void input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        moveCount = scanner.nextInt();
    }

    public static int carCount() {
        return carCount;
    }

    public static int moveCount() {
        return moveCount;
    }

}
