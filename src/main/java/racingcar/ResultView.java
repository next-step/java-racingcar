package racingcar;

import java.util.Scanner;

public class ResultView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void drawCarPosition(int position) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(position));
        System.out.println(sb.toString());
    }
}
