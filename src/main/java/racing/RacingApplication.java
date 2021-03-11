package racing;

import racing.controller.RacingController;
import racing.domain.RacingHost;
import racing.domain.RandomRacingHost;
import racing.io.ConsoleOutputDriver;
import racing.io.OutputDriver;
import racing.view.InputView;
import racing.view.ResultView;


public class RacingApplication {


    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carSymbol = "-";
        OutputDriver outputDriver = new ConsoleOutputDriver();
        ResultView resultView = new ResultView(outputDriver, carSymbol);
        RacingHost racingHost = new RandomRacingHost();

        RacingController racingController = new RacingController(inputView, resultView, racingHost);
        racingController.run();
    }

}
