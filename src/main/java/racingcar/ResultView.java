package racingcar;

import java.util.List;

public class ResultView {

    public static void printResultView(List<RoundResult> gameResult) {
        System.out.println();
        System.out.println("실행 결과");

        for (RoundResult roundResult : gameResult) {
            for (int i = 0; i < roundResult.getResults().size(); i++) {
                System.out.println("-".repeat(roundResult.getResults().get(i)));
            }
            System.out.println();
        }
    }
}
