package study.nextstep.stage3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private static final String CAR_PATH_CHARACTER = "-";

    class DefaultStandardIORenderer implements Renderer {
        @Override
        public void render(GameStatus status) {
            for(int i = 0; i < status.size(); i ++){
                System.out.println(CAR_PATH_CHARACTER.repeat(status.renderCarPosition(i)));
            }
            System.out.println();
        }

        @Override
        public void renderFirstStatus(GameStatus status) {
            System.out.println("실행 결과");
            render(status);
        }
    }

    public GameStatus gameStatus;
    private Renderer renderModule;

    public RacingGame(InputView view) {
        gameStatus = new GameStatus(view.getCars(), view.getCount());
    }

    public RacingGame randomModule(Random randomModule){
        gameStatus.setRandomModule(randomModule);
        return this;
    }

    public void run(){
        renderModule.renderFirstStatus(gameStatus);
        while( gameStatus.isTurnEnd() ){
            gameStatus.turn();
        }
    }
}
