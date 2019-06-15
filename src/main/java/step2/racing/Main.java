package step2.racing;

import step2.racing.inputter.SystemConsoleInputter;
import step2.racing.service.RacingService;
import step2.racing.ui.InputView;
import step2.racing.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView(new SystemConsoleInputter());
        ResultView resultView = new ResultView(System.out);

        RacingService racingService = new RacingService(inputView, resultView);
        racingService.start();
    }
}
