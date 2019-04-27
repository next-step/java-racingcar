package racing;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int inputCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        return carNum;
    }

    public static int inputTryTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();
        return tryTime;
    }
}
