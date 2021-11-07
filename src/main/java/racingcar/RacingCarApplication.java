package racingcar;

import racingcar.moverule.RandomMoveRule;
import racingcar.game.RacingCarGame;
import racingcar.gameinfo.CountInfo;
import racingcar.gameinfo.RacingCarGameInfo;
import racingcar.gameinfo.RacingCarGameRound;
import racingcar.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        CountInfo countInfo = InputView.getCountInfo();
        RacingCarGameInfo info = new RacingCarGameInfo(new RacingCarGameRound(new RandomMoveRule()), countInfo);
        RacingCarGame game = new RacingCarGame(info);
        game.start();
    }
}