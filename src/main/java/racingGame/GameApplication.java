package racingGame;

import racingGame.Business.Process;

public class GameApplication {
    
    public static void main(String[] args) {
        Process process = new Process();
        process.run(InputView.inputCarNum(), InputView.inputMoveNum());
    }
}
