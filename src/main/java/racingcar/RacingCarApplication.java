package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.DelimiterCreationStrategy;
import racingcar.domain.FourOrMore;
import racingcar.domain.RacingGame;
import racingcar.domain.SystemRandomHolder;
import racingcar.service.RacingGameService;

public class RacingCarApplication {
    public static void main(String[] args) {
        DelimiterCreationStrategy creationStrategy = new DelimiterCreationStrategy();
        SystemRandomHolder randomHolder = new SystemRandomHolder();
        FourOrMore moveStrategy = new FourOrMore(randomHolder);
        RacingGame racingGame = new RacingGame(moveStrategy, creationStrategy);
        RacingGameService racingGameService = new RacingGameService(racingGame);
        RacingGameController controller = new RacingGameController(racingGameService);

        controller.run();
    }
}
