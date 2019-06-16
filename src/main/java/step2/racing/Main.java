package step2.racing;

import step2.racing.dto.RacingInfo;
import step2.racing.dto.RacingResult;
import step2.racing.inputter.SystemConsoleInputter;
import step2.racing.service.RacingService;
import step2.racing.ui.InputView;
import step2.racing.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView(new SystemConsoleInputter());
        int carCount = inputView.askCarCount();
        int attempts = inputView.askAttempts();

        RacingInfo racingInfo = new RacingInfo(carCount, attempts);
        RacingService racingService = new RacingService(racingInfo);
        RacingResult racingResult = racingService.run();

        ResultView resultView = new ResultView(System.out);
        resultView.printRacingResult(racingResult);
    }
}
