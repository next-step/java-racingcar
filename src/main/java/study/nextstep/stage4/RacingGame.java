package study.nextstep.stage4;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private Random randomModule;
    private String[] names;
    private GameStatus status;
    private int totalGameRun;
    private int currentGameRun;

    public RacingGame(InputView view){
        names = view.getNames();
        randomModule = new Random();

        status = new GameStatus(names.length);

        this.totalGameRun = view.getCount();
        this.currentGameRun = 0;
    }

    public RacingGame randomModule(Random randomModule) {
        this.randomModule = randomModule;
        return this;
    }

    public void run(Renderer renderer) {
        renderer.renderFirstStatus(status);
        for(int i = currentGameRun; i < totalGameRun; i++) {
            status.totalTurn(randomModule);
            renderer.render(names, status);
        }
    }
}
