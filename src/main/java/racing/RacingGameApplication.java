package racing;

import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;
import racing.service.RacingGameService;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInformation raceInformation = inputView.createByUserInput();

        RacingGameService racingGameService = new RacingGameService();
        List<RacingGameResult> racingGameResults = racingGameService.executeRace(raceInformation);

        OutputView outPutView = new OutputView();
        outPutView.printGuidance();
        outPutView.printRacingResult(racingGameResults);
        outPutView.printRacingWinners(racingGameResults);
    }
}
