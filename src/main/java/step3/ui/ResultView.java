package step3.ui;

import java.util.List;
import step3.domain.CarRunResult;
import step3.domain.Round;

public class ResultView {

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
        List<CarRunResult> carRunResults = playedRound.getCarRunResults();
        for (CarRunResult result : carRunResults) {
            System.out.println(result.generateCarRunResultString());
        }
        System.out.println();
    }

}
