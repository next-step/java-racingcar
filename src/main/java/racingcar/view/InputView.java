package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int askTime() {
        System.out.println("이동 횟수?");
        return SCANNER.nextInt();
    }

    public static int askCarCount() {
        System.out.println("자동차 수?");
        return SCANNER.nextInt();
    }

}
