import game.Game;
import game.InputView;
import game.ResultView;
import game.gambling.GamblingGame;
import game.gambling.GamblingGameSettings;
import game.gambling.GamblingResult;
import game.gambling.GamblingResultView;
import game.racing.RacingGame;
import game.racing.RacingGameSettings;
import game.racing.RacingResult;
import game.racing.RacingResultView;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class GameApplication {

    public static void main(String[] args) {
        startRacing();
        startGamble();
    }

    private static void startGamble() {
        GamblingGameSettings settings = new GamblingGameSettings();
        InputView inputView = new InputView(settings);
        inputView.render();

        Game<GamblingResult> game = new GamblingGame(settings);
        game.run();

        ResultView<GamblingResult> resultView = new GamblingResultView();
        resultView.render(game.getResultEntity());
    }

    private static void startRacing() {
        RacingGameSettings settings = new RacingGameSettings();
        InputView inputView = new InputView(settings);
        inputView.render();

        Game<RacingResult> game = new RacingGame(settings);
        game.run();

        ResultView<RacingResult> resultView = new RacingResultView();
        resultView.render(game.getResultEntity());
    }

}
