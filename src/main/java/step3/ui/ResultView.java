package step3.ui;

import java.util.List;
import step3.domain.CarRacingGameResult;
import step3.domain.CarRunResult;
import step3.domain.Round;

public class ResultView {

    private static ResultView instance = new ResultView();


    private ResultView() {
    }

    public static ResultView getInstance() {
        return instance;
    }


    public void printAllRoundResult(CarRacingGameResult result) {
        System.out.println("실행 결과: ");
        List<Round> playedRounds = result.getPlayedRounds();

        for (Round playedRound : playedRounds) {
            printRoundResult(playedRound);
        }
        System.out.println(result.getWinnerNames()+"가 최종 우승했습니다.");
    }

    private void printRoundResult(Round playedRound) {
        List<CarRunResult> carRunResults = playedRound.getCarRunResults();
        for (CarRunResult result : carRunResults) {
            System.out.println(result.generateCarRunResultString());
        }
        System.out.println();
    }

}
