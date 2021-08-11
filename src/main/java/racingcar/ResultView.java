package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(List<List<Integer>> carsPositionPerRound) {
        printResultTitle();
        carsPositionPerRound.forEach(ResultView::printCarPositionOfRound);
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPositionOfRound(List<Integer> positions) {
        positions.forEach(ResultView::printCarPositionAsHyphens);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printCarPositionAsHyphens(Integer position) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < position; k++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
}
