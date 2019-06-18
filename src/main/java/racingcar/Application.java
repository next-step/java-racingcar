package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.RacingGame;

public class Application {

    private static RacingGame racingGame;

    public static void main(String[] args) {
        OutputView.start();

        while(true){
            try{
                String askCarNames = InputView.askCarNames();
                int time = InputView.askRound();
                racingGame = RacingGame.generate(time, askCarNames);
                OutputView.ready(racingGame.getResult());

                while (!racingGame.isGameOver()){
                    OutputView.playResult(racingGame.racing());
                }
                OutputView.winningResult(racingGame.getFinalResult());
                break;
            }catch (Exception e){
                System.out.println(e);
            }
        }
        OutputView.end();
    }
}
