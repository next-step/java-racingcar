package racingGame;

import java.util.List;
import racingGame.Business.Process;
import racingGame.model.ProgressRecord;

public class GameApplication {
    
    public static void main(String[] args) {
        Process process = new Process();
        List<ProgressRecord> result = process.run(InputView.inputCarNum(), InputView.inputMoveNum());
    }
}
