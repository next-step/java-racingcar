package carracing;

import java.util.List;

public class OutputView {
    public static void printTotalResult(List<List<String>> result) {
        System.out.println("실행 결과");
        for (List<String> oneRound : result) {
            printOneRoundResult(oneRound);
            System.out.println();
        }
    }

    private static void printOneRoundResult(List<String> oneRound) {
        for (String distanceString : oneRound) {
            System.out.println(distanceString);
        }
    }
}
