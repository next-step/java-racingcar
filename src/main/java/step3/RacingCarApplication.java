package step3;

import step3.domain.GameInfo;
import step3.domain.Play;
import step3.view.InputView;

import java.util.List;

public class RacingCarApplication {

    private static final InputView INPUT_VIEW = new InputView();
    private static final Play PLAY = new Play();

    public static void main(String[] args) {
        List<String> names = INPUT_VIEW.input();
        int count = INPUT_VIEW.count();

        GameInfo gameInfo = new GameInfo(names, count);
        PLAY.playGame(gameInfo);
    }
}
