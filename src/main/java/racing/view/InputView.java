package racing.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner sc = new Scanner(System.in);

    public static int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    public static int repeatCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
