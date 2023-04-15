package racing;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static String carNames;
    private static int moveCount;

    public static void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        moveCount = scanner.nextInt();
    }

    public static String carNames() {
        return carNames;
    }

    public static int moveCount() {
        return moveCount;
    }

}
