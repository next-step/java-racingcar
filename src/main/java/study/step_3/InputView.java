package study.step_3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int numberOfCars() {
        System.out.println("자동차는 몇 대인가요?");
        return scanner.nextInt();
    }

    public static int numberOfTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
