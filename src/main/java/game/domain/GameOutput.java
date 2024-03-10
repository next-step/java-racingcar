package game.domain;

import game.util.ResultView;

public class GameOutput {

    private static final String EXECUTION_RESULT = "\n실행 결과";

    private GameOutput() {
    }

    public static GameOutput process(){
        ResultView.printPlainMessage(EXECUTION_RESULT);
        return new GameOutput();
    }
}
