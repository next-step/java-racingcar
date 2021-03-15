package car;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void receiveInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        // todo: do something with input
    }
}
