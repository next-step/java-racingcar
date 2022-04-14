import racingcar.RacingInputData;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {

        RacingInputData racingInputData = new RacingInputData(InputView.show());

        RacingGame racingGame = new RacingGame(new ZeroToNineRandomPolicy());
        racingGame.startRacingGame(racingInputData);

        ResultView.show(racingGame.getResult());
    }

}
