package racingcar;

import java.util.Scanner;

public class ResultView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void drawCarPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
