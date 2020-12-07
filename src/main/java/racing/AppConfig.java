package racing;

import racing.application.RacingService;
import racing.domain.Moveable;
import racing.infra.NextStepCarFactory;
import racing.infra.NextStepMoveable;
import racing.ui.RacingController;

public class AppConfig {

    public RacingController racingController() {
        return new RacingController(racingService());
    }

    public RacingService racingService() {
        return new RacingService(moveable(), nextStepCarFactory());
    }

    public Moveable moveable() {
        return new NextStepMoveable();
    }

    public NextStepCarFactory nextStepCarFactory() {
        return new NextStepCarFactory();
    }
}
