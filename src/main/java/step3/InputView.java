package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
