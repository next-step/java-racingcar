package racing;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);
    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

     public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
