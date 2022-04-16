package config;

import controller.CarRacingController;
import service.CarRacingService;
import util.MoveStrategy;
import util.RandomNumberMove;
import view.InputView;
import view.ResultView;

public class AppConfig {

    public CarRacingController carRacingController() {
        return new CarRacingController(inputView(), resultView(), carRacingService());
    }

    public CarRacingService carRacingService() {
        return new CarRacingService(moveStrategy());
    }

    public InputView inputView() {
        return InputView.getInstance();
    }

    public ResultView resultView() {
        return ResultView.getInstance();
    }

    public MoveStrategy moveStrategy() {
        return RandomNumberMove.getInstance();
    }
}
