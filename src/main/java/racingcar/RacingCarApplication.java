package racingcar;

import racingcar.moverule.RandomMoveRule;
import racingcar.game.RacingCarGame;
import racingcar.gameinfo.CountInfo;
import racingcar.gameinfo.RacingCarGameInfo;
import racingcar.gameinfo.RacingCarGameRound;
import racingcar.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        try {
            CountInfo countInfo = InputView.getCountInfo();
            RacingCarGameInfo info = new RacingCarGameInfo(new RacingCarGameRound(new RandomMoveRule()), countInfo);
            RacingCarGame game = new RacingCarGame(info);
            game.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "게임을 종료합니다.");
            System.exit(0);
        }
    }
}