package racingcar;

import racingcar.game.RacingCarGame;
import racingcar.gameinfo.GameInfo;

public class RacingCarApplication {

    public static void main(String[] args) {
        try {
            RacingCarGame game = new RacingCarGame(GameInfo.randomMoveGame());
            game.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "게임을 종료합니다.");
            System.exit(0);
        }
    }
}