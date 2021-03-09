package racing;

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

        RacingController racingController = new RacingController(inputView, resultView);
        racingController.run();
    }

}
