package racingcar;

import java.util.Scanner;

public class ResultView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String LINE = "-".repeat(5);

    public static void roundStart(int roundNumber) {
        System.out.println(LINE + roundNumber + " 라운드 시작!" + LINE);
    }

    public static void drawCarPosition(int position) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(position));
        System.out.println(sb.toString());
    }
}
