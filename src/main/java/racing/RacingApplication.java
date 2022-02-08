package racing;

import racing.domain.RacingInfo;
import racing.service.Judgement;
import racing.service.Racing;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {

        String carNames = InputView.getCars();
        int roundNumber = InputView.getRoundNumber();
        RacingInfo info = RacingInfo.of(carNames, roundNumber);

        Racing racing = new Racing(info);
        racing.race();
        ResultView.printResult(racing.getRoundResults());

        Judgement judgement = new Judgement(racing.getLastResult());
        ResultView.printWinners(judgement.judgeWinner());
    }
}
