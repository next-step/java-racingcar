package carracing.ui;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputCarCount() {
        return sc.nextInt();
    }

    public static int inputTryCount() {
        return sc.nextInt();
    }
}
