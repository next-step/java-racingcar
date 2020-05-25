package study.nextstep.stage4;

import java.util.Random;

public class RacingGame {
    private Random randomModule;
    private String[] names;
    private GameStatus status;

    public RacingGame(InputView view){
        names = view.getNames();
        randomModule = new Random();

        status = new GameStatus(names.length, view.getCount());
    }

    public RacingGame randomModule(Random randomModule) {
        this.randomModule = randomModule;
        return this;
    }

    public GameStatus run(Renderer renderer) {
        renderer.renderFirstStatus(status);
        while( status.totalTurn(randomModule) ){
            renderer.render(names, status);
        }
        return status;
    }
}
