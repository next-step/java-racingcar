package racingGame;

import racingGame.business.Process;

public class GameApplication {
    
    public static void main(String[] args) {
        Process process = new Process();
        ResultView.printAllResult(process.run(InputView.inputCarName(), InputView.inputMoveNum()));
    }

}
