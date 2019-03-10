package racing.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputCount() {
        return nextInt("자동차 대수는 몇 대 인가요?");
    }

    public static int inputTime() {
        return nextInt("시도할 회수는 몇 회 인가요?");
    }

    private static int nextInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
}
