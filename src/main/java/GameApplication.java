import game.core.domain.Game;
import game.core.view.ResultView;
import game.gambling.GamblingGame;
import game.gambling.GamblingInputView;
import game.gambling.GamblingResult;
import game.gambling.GamblingResultView;
import game.racing.RacingGame;
import game.racing.RacingInputView;
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
        GamblingInputView inputView = new GamblingInputView();
        inputView.renderAndAcceptInput();

        Game<GamblingResult> game = new GamblingGame(inputView.getUserNames(), inputView.getNumberOfRound());
        game.run();

        ResultView<GamblingResult> resultView = new GamblingResultView();
        resultView.render(game.getResultEntity());
    }

    private static void startRacing() {
        RacingInputView inputView = new RacingInputView();
        inputView.renderAndAcceptInput();

        Game<RacingResult> game = new RacingGame(inputView.getCarNames(), inputView.getNumberOfRound());
        game.run();

        ResultView<RacingResult> resultView = new RacingResultView();
        resultView.render(game.getResultEntity());
    }

}
