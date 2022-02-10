package racing;

import racing.dto.RacingInfoDto;
import racing.service.Judgement;
import racing.service.Racing;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {

        String carNames = InputView.getCars();
        int roundNumber = InputView.getRoundNumber();
        RacingInfoDto infoDto = RacingInfoDto.of(carNames, roundNumber);

        Racing racing = new Racing(infoDto.getCars(), infoDto.getRound(), infoDto.getRound().getRoundNumber());
        racing.race();
        ResultView.printResult(racing.getRoundResults());

        Judgement judgement = new Judgement(racing.getLastResult());
        ResultView.printWinners(judgement.judgeWinner());
    }
}
