package study.nextstep.stage5;

import study.nextstep.stage5.domain.GameStatus;
import study.nextstep.stage5.view.InputView;
import study.nextstep.stage5.view.Renderer;

import java.util.Random;

public class RacingGameController {
    private GameStatus status;

    public RacingGameController(InputView view){
        status = new GameStatus(view.getNames(), view.getCount());
    }

    public GameStatus run(Renderer renderer, Random randomModule) {
        renderer.renderFirstStatus(status);
        while (status.totalTurn(randomModule)) {
            renderer.render(status);
        }
        return status;
    }
}
