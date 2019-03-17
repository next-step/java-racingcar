package racing.service;

import racing.application.Condition;
import racing.application.RacingGame;
import racing.infrastructure.RandomCondition;
import racing.view.RacingGameRequestView;
import racing.view.RacingGameResultView;

public class RacingGameService {
    private static final Condition condition = new RandomCondition();

    public static RacingGameResultView run(RacingGameRequestView view) {
        RacingGame game = new RacingGame(view, condition);
        return game.start();
    }
}
