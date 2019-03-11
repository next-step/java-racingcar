package racingcar;

import java.util.List;

public class OutputView {
    public static void printIntroduction() {
        System.out.println("실행결과");
    }

    public static void printResult(List<Integer> positions) {
        positions.forEach(OutputView::showMovingPath);
        System.out.println();
    }

    private static void showMovingPath(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
}
