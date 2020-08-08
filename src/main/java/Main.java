import racingcar.*;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        GameInputs userArgs = inputView.createUserArgument();
        RacingGame racingGame = RacingGame.createGame(userArgs);

        try {
            GameResults results = racingGame.start();

            resultView.printGameResult(results);
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
