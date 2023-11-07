package racewinner.view;

import java.util.List;

public class ResultView {

    public static void emptyLine() {
        System.out.println();
    }

    public static void print(final String string) {
        System.out.println(string);
    }

    public static void printWinner(final List<String> winnerList) {
        System.out.println(String.join(",", winnerList) + "가 최종 우승했습니다.");
    }
}
