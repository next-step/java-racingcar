package racing;

import java.util.Scanner;

public class RacingCarGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static Cars start() {
        System.out.println("자동차 수를 입력하세요: ");
        int carCount = scanner.nextInt();
        System.out.println("이동 횟수를 입력하세요: ");
        int moveCount = scanner.nextInt();

        Cars result = new Cars(carCount, moveCount).move();
        View.print(result);
        return result; // 테스트를 위해 리턴
    }
}
