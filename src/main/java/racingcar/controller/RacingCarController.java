package racingcar.controller;

import racingcar.domain.dto.InputDto;
import racingcar.domain.model.Cars;
import racingcar.domain.service.RacingGameService;
import racingcar.view.ResultView;

public class RacingCarController {

    private static final RacingCarController RACING_CAR_CONTROLLER = new RacingCarController();

    private RacingCarController() {
    }

    public static RacingCarController getInstance() {
        return RACING_CAR_CONTROLLER;
    }

    public void racingGame(InputDto inputDto) {
        RacingGameService racingGameService = new RacingGameService(Cars.from(inputDto.getName()));
        Cars cars = racingGameService.gameStart(inputDto.getTryCount());

        ResultView resultView = new ResultView(cars);
        resultView.outputGameResult();
    }
}
