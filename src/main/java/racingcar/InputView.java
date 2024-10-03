package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarNumber() {
        System.out.println("자동차 개수는 몇 개 인가요?");
        return scanner.nextInt();
    }

    public static int getRoundNumber() {
        System.out.println("시도 할 횟수는 몇 번 인가요?");
        return scanner.nextInt();
    }
}
