package racing;

import racing.domain.Judgement;
import racing.domain.Racing;
import racing.domain.RacingResult;
import racing.dto.RacingInfo;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingInfo info = InputView.getRacingInfo();

        Racing racing = new Racing(info);
        racing.race();
        RacingResult result = racing.getResult();

        Judgement judgement = new Judgement(result.getLastRoundResult());
        ResultView.printResultAndWinners(result.getRacingResult(), judgement.judgeWinner());
    }
}
