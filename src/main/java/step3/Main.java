package step3;

import step3.game.RacingGameImpl;
import step3.game.RacingInfomation;
import step3.view.InputView;

public class Main {
    public static void main(String[] args) {
        RacingGameImpl game = new RacingGameImpl();
        InputView inputView = InputView.getInstance();
        RacingInfomation racingInfomation = inputView.execute();

        game.execute(racingInfomation);

    }
}
