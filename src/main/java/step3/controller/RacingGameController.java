package step3.controller;

import step3.domain.Cars;
import step3.domain.GameInfo;
import step3.service.RacingGameService;
import step3.view.InputView;

import java.util.List;

public class RacingGameController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final RacingGameService RACING_GAME_SERVICE = new RacingGameService();

    public static void start() {
        List<String> names = INPUT_VIEW.input();
        int count = INPUT_VIEW.count();

        GameInfo gameInfo = new GameInfo(new Cars(names), count);
        RACING_GAME_SERVICE.playGame(gameInfo);
    }
}
