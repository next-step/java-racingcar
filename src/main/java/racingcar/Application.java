package racingcar;


import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomForwardStrategy;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    private static final int START_FROM_ZERO = 0;

    public static void main(String[] args) {
        InputView inputView = InputView.instance();
        inputView.processConsoleInput();
        RacingService racingService = RacingService.from(Cars.of(inputView.getInputDto().getSplitUserInput(), new RandomForwardStrategy()));
        RacingController racingController = new RacingController(racingService, ResultView.instance());
        for (int time = START_FROM_ZERO; time < inputView.getInputDto().getRacingTime(); time++) {
            racingController.startRacing();
            racingController.carsCurrentStatements();
        }
        System.out.println(racingController.finishRacing());
    }

}
