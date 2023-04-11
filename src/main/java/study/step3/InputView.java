package study.step3;

import java.util.Scanner;

public class InputView {

    public static Scanner createScanner() {
        return new Scanner(System.in);
    }

    public static void askCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?\n");
    }

    public static void aksFinishCount() {
        System.out.println("마지막 바퀴는 몇바퀴 인가요?\n");
    }
}
