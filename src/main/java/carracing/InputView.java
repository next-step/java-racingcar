package carracing;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static int inputCarNumber() {
        return input("자동차 대수는 몇 대 인가요?");
    }

    public static int inputRound() {
        return input("시도할 회수는 몇 회 인가요?");
    }

    private static int input(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
