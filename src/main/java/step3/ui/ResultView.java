package step3.ui;

import java.util.ArrayList;
import java.util.List;
import step3.domain.Round;

public class ResultView {

    private static final String PROGRESS_SYMBOL = "-";

    private static ResultView instance = new ResultView();


    private ResultView() {
    }

    public static ResultView getInstance() {
        return instance;
    }


    public void printAllRoundResult(List<Round> playedRounds) {
        System.out.println("실행 결과: ");

        for (Round playedRound : playedRounds) {
            printRoundResult(playedRound);
        }
    }

    private void printRoundResult(Round playedRound) {
        ArrayList<Integer> results = playedRound.getResults();
        for (int runDistance : results) {
            System.out.println(generateProgressString(runDistance));
        }
        System.out.println();
    }

    private String generateProgressString(int runDistance) {
        String progress = "";
        for (int i = 0; i < runDistance; i++) {
            progress = progress + PROGRESS_SYMBOL;
        }
        return progress;
    }

}
