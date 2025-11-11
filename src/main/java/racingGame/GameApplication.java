package racingGame;

import java.util.ArrayList;
import java.util.List;
import racingGame.Business.Process;
import racingGame.Response.GameResult;
import racingGame.model.ProgressRecord;

public class GameApplication {
    
    public static void main(String[] args) {
        Process process = new Process();
        ResultView.printAllResult(showResult(process.run(InputView.inputCarNum(), InputView.inputMoveNum())));
    }

    private static List<GameResult> showResult(List<ProgressRecord> progressRecords) {
        List<GameResult> gameResults = new ArrayList<>();
        gameResults.add(new GameResult(progressRecords));
        return gameResults;
    }
}
