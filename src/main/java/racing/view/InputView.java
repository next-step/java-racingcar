package racing.view;

import java.util.Scanner;

public class InputView {
    public static final String STR1 = "자동차 대수는 몇 대 인가요?";
    public static final String STR2 = "시도할 회수는 몇 회 인가요?";
    public static final Scanner scanner = new Scanner(System.in);

    public int carInput() {
        System.out.print(STR1);
        return input();
    }

    public int cntInput() {
        System.out.print(STR2);
        return input();
    }

    private static int input() {
        int input = scanner.nextInt();
        if (input < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        return input;
    }

}
