package racing;

import racing.domain.MoveRule;
import racing.domain.RandomMoveRule;
import racing.domain.RoundResults;
import racing.dto.RacingInfo;
import racing.domain.Judgement;
import racing.domain.Racing;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        String carNames = InputView.getCars();
        int roundNumber = InputView.getTotalRoundNumber();
        MoveRule moveRule = new RandomMoveRule();
        RacingInfo infoDto = RacingInfo.of(carNames, roundNumber, moveRule);

        Racing racing = new Racing(infoDto.getCars(), infoDto.getTotalRoundNumber());
        racing.race();

        RoundResults results = racing.getResults();
        Judgement judgement = new Judgement(results.getLastRawResult());

        ResultView.printResultAndWinners(results.getRawResults(), judgement.judgeWinner());
    }
}
