package racingcar.ui;

import racingcar.application.RacingCarGameService;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

public class RacingGameController {

    private final RacingCarGameService service;

    public RacingGameController(RacingGameRequest request) {
        service = new RacingCarGameService();
        service.initializeCars(request.getCarNumber());
    }

    public RacingGameResponse gameStart() {
        RacingGameResponse response = service.getAllCarMoveCount();
        return response;
    }
}
