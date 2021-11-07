package racingcar;

import racingcar.game.RacingCarGame;
import racingcar.gameinfo.CountInfo;
import racingcar.moverule.RandomMoveRule;
import racingcar.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        try {
            CountInfo countInfo = InputView.getCountInfo();
            RacingCarGame game = new RacingCarGame(countInfo, new RandomMoveRule());
            game.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "게임을 종료합니다.");
            System.exit(0);
        }
    }
}