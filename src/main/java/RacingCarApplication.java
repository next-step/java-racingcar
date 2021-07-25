import racingcar.controller.RacingCarController;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;

public class RacingCarApplication {

    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingCarController racingCarController = RacingCarController
                .createFromUserInput(moveStrategy);
        racingCarController.run();
    }
}
