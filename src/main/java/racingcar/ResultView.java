package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public static void printResult(List<int[]> posesForEachRound) {
        printResultTitle();
        posesForEachRound.stream().forEach(posses -> printCarPositionOfRound(posses));
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPositionOfRound(int[] poses) {
        Arrays.stream(poses).forEach(position -> printPositionDrawing(position));
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println("");
    }

    private static void printPositionDrawing(int position) {
        System.out.println(makePositionDrawing(position));
    }

    private static String makePositionDrawing(int position) {
        StringBuilder sb  = new StringBuilder();
        for (int k = 0; k < position; k++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
