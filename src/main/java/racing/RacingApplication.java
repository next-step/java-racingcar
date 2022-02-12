package racing;

import racing.domain.Judgement;
import racing.domain.Racing;
import racing.domain.RoundResults;
import racing.dto.RacingInfo;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingInfo info = InputView.getRacingInfo();

        Racing racing = new Racing(info);
        racing.race();
        RoundResults results = racing.getResults();

        Judgement judgement = new Judgement(results.getLastRoundResult());
        ResultView.printResultAndWinners(results.getTotalRoundResults(), judgement.judgeWinner());
    }
}
