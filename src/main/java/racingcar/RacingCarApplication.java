package racingcar;

import racingcar.application.RacingCarService;
import racingcar.domain.MoveCommand;
import racingcar.infra.RandomNumber;
import racingcar.presentation.InputView;
import racingcar.presentation.RacingCarController;
import racingcar.presentation.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarService racingCarService = racingCarService(moveCommand());
        RacingCarController racingCarController = racingCarController(racingCarService);

        racingCarController.startGame();
    }


    private static RacingCarService racingCarService(MoveCommand moveCommand) {
        return new RacingCarService(moveCommand);
    }

    private static MoveCommand moveCommand() {
        return new MoveCommand(new RandomNumber());
    }

    private static RacingCarController racingCarController(RacingCarService racingCarService) {
        return new RacingCarController(new InputView(), new ResultView(), racingCarService);
    }
}
