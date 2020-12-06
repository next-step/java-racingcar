package racing;

import racing.application.RacingService;
import racing.domain.Moveable;
import racing.domain.RacingGame;
import racing.infra.NextStepMoveable;
import racing.ui.RacingController;

public class AppConfig {

    public RacingController racingController() {
        return new RacingController(racingService());
    }

    public RacingService racingService() {
        return new RacingService(moveable());
    }

    public Moveable moveable() {
        return new NextStepMoveable();
    }
}
