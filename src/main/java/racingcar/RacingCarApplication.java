package racingcar;

import racingcar.game.RacingCarGame;
import racingcar.gameinfo.GameInfo;
import racingcar.game.GameInfoGetter;

public class RacingCarApplication {

    public static void main(String[] args) {
        try {
            GameInfo carCountGame = GameInfoGetter.CarCountGame(); // 이걸로 기존 게임도 실행 가능
            GameInfo carNamesGame = GameInfoGetter.CarNamesGame();
            RacingCarGame game = new RacingCarGame(carNamesGame);
            game.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "게임을 종료합니다.");
            System.exit(0);
        }
    }
}