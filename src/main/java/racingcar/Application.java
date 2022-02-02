package racingcar;


import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        RacingService racingService = RacingService.from(Cars.instance());
        RacingController racingController = new RacingController(racingService,
            InputView.instance(), ResultView.instance());
        racingController.setUpRacing();
        racingController.startRacing();
        racingController.finishRacing();
    }

}
