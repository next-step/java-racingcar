package racingcar.controller;

import java.util.List;
import racingcar.domain.Movement;
import racingcar.domain.dto.CarDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, Movement movement) {
        this.outputView = outputView;
        this.racingService = new RacingService(movement, inputView.readNames(), inputView.putCoins());
    }

    public void run() {
        outputView.printBeforeResult();
        while (racingService.isRaceOnGoing()) {
            List<CarDto> result = racingService.race();
            outputView.printProgress(result);
        }
        outputView.printWinners(racingService.getWinners());
    }

}
