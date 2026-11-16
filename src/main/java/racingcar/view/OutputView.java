package racingcar.view;

import racingcar.dto.RoundResult;

import java.util.List;

public class OutputView {


    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRaceResult(List<RoundResult> results) {
        for (RoundResult result : results) {
            printRoundResult(result);
        }
    }

    private static void printRoundResult(RoundResult result) {
        for (int position : result.getPosition()) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }


}
