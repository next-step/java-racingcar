import game.Game;
import game.InputView;
import game.ResultView;
import game.racing.RacingGame;
import game.racing.RacingGameSettings;

import static game.racing.RacingGameSettings.*;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class GameApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.addMessage(KEY_NUMBER_OF_CAR, TEXT_NUMBER_OF_CAR);
        inputView.addMessage(KEY_NUMBER_OF_TIMES, TEXT_NUMBER_OF_TIMES);
        inputView.render();

        RacingGameSettings settings = new RacingGameSettings();
        settings.setNumberOfCar(inputView.getInput(KEY_NUMBER_OF_CAR));
        settings.setNumberOfTimes(inputView.getInput(KEY_NUMBER_OF_TIMES));

        Game game = new RacingGame(settings);
        game.run();

        ResultView resultView = new ResultView(game.getResult());
        resultView.render();

    }

}
