import game.Game;
import game.InputView;
import game.ResultView;
import game.racing.RacingGame;
import game.racing.RacingGameSettings;
import game.racing.RacingResultView;
import game.racing.TrackingLog;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class GameApplication {

    public static void main(String[] args) {

        RacingGameSettings settings = new RacingGameSettings();
        InputView inputView = new InputView(settings);
        inputView.render();

        Game<TrackingLog> game = new RacingGame(settings);
        game.run();

        ResultView<TrackingLog> resultView = new RacingResultView();
        resultView.render(game.getResult());

    }

}
