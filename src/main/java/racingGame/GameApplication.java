package racingGame;

import java.util.ArrayList;
import java.util.List;
import racingGame.Business.Process;
import racingGame.Response.GameFinalResult;
import racingGame.Response.GameResult;

public class GameApplication {
    
    public static void main(String[] args) {
        Process process = new Process();
        ResultView.printAllResult(process.run(InputView.inputCarName(), InputView.inputMoveNum()));
    }

}
