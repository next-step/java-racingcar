package carracing;

import java.util.Scanner;

public class InputView {
    public static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
