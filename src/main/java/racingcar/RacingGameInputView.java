package racingcar;

import java.util.Scanner;

public class RacingGameInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputMoveNumber() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
