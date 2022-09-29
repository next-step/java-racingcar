package step3;

public class RacingController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarService racingCarService = new RacingCarServiceImpl();

        inputView.input();

        resultView.print(racingCarService.racing());
    }
}
