package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printResult(List<List<Integer>> result) {
        System.out.println("실행 결과");

        for(List<Integer> r : result) {
            printTrack(r);
            System.out.println();
        }
    }

    private static void printTrack(List<Integer> tracks) {
        for(int i : tracks) {
            System.out.print("-".repeat(i));
            System.out.println();
        }
    }
}
