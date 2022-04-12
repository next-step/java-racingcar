package racingcar;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    public final static Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static void askTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void askCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }
}
