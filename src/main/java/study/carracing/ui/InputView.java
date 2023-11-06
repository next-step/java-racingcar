package study.carracing.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
