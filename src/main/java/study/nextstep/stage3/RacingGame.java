package study.nextstep.stage3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    public GameStatus gameStatus;
    private Renderer renderModule;

    public RacingGame(InputView view, Random randomModule) {
        gameStatus = new GameStatus(view.getCars(), view.getCount(), randomModule);
        renderModule = new DefaultStandardIORenderer();
    }

    public void run(){
        renderModule.renderFirstStatus(gameStatus);
        while( gameStatus.isTurnEnd() ){
            gameStatus.turn();
        }
    }
}
