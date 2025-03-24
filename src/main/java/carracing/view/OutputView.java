package carracing.view;

import java.util.List;

public class OutputView {

    public static final String JOIN_DELIMITER = ", ";

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

    public static void printWinners(List<String> winners) {
        String winnerString = String.join(JOIN_DELIMITER, winners);
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}
