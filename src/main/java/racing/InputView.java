package racing;

import java.util.Scanner;

public class InputView {
    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇대 인가요?");
        return inputCount();
    }

    public static int inputRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputCount();
    }

    private static int inputCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
