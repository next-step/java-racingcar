package racing;

import racing.application.RacingService;
import racing.domain.Moveable;
import racing.domain.RacingGame;
import racing.ui.RacingController;

public class AppConfig {

    public RacingController racingController() {
        return new RacingController(racingService());
    }

    public RacingService racingService() {
        return new RacingService(racingGame());
    }

    public RacingGame racingGame() {
        return new RacingGame(moveable());
    }

    public Moveable moveable() {
        return () -> true;
    }
}
