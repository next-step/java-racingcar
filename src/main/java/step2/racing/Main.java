package step2.racing;

import step2.racing.scanner.SystemConsoleInputScanner;
import step2.racing.service.RacingService;
import step2.racing.ui.InputView;
import step2.racing.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView(new SystemConsoleInputScanner());
        ResultView resultView = new ResultView(System.out);

        RacingService racingService = new RacingService(inputView, resultView);
        racingService.start();
    }
}
