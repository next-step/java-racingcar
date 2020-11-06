package step3;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    static void close() {
        scanner.close();
    }
}
