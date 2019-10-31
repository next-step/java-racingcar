package step2;

import step2.domain.GameResult;
import step2.domain.GameRunner;
import step2.view.StandardInputView;
import step2.view.StandardOutputView;
import step2.view.format.GameResultNamedWinnerStringFormatter;

public class Main {
    public static void main(String[] args) {
        final GameRunner gameRunner = new StandardInputView().makeGameRunner();
        final GameResult gameResult = gameRunner.simulate();
        final String output = new GameResultNamedWinnerStringFormatter(".").format(gameResult);

        new StandardOutputView().print(output);
    }
}
