package step3;

import java.util.List;

public class ResultView {

    public static final String EMPTY_STRING = "";
    private static final String PROCESS_BAR = "-";

    public void showResult(List<List<Integer>> racingResults) {
        System.out.println("실행 결과");
        racingResults.forEach(result -> showCurrentPositions(result));
    }

    private void showCurrentPositions(List<Integer> currentPositions) {
        currentPositions.forEach(position -> expressResultWithProcessBar(position));
        System.out.println();
    }

    private void expressResultWithProcessBar(Integer position) {
        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < position; i++) {
            sb.append(PROCESS_BAR);
        }
        System.out.println(sb);
    }
}



