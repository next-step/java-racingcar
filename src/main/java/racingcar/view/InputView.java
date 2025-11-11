package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readInput();
    }

    public static int readGameCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return readInput();
    }

    private static int readInput() {
        return scanner.nextInt();
    }
}
