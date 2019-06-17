package racing;

import racing.dto.RacingInfo;
import racing.dto.RacingResult;
import racing.inputter.SystemConsoleInputter;
import racing.service.RacingService;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView(new SystemConsoleInputter());
        String carNames = inputView.askCarNames();
        int attempts = inputView.askAttempts();

        RacingInfo racingInfo = RacingInfo.of(carNames, attempts);
        RacingService racingService = new RacingService(racingInfo);
        RacingResult racingResult = racingService.run();

        ResultView resultView = new ResultView(System.out);
        resultView.printRacingResult(racingResult);
    }
}
