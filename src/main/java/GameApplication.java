import game.core.domain.Game;
import game.core.view.ResultView;
import game.gambling.domain.GamblingGame;
import game.gambling.view.GamblingInputView;
import game.gambling.domain.GamblingResult;
import game.gambling.view.GamblingResultView;
import game.racing.domain.RacingGame;
import game.racing.view.RacingInputView;
import game.racing.domain.RacingResult;
import game.racing.view.RacingResultView;

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
