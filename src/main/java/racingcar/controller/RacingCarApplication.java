package racingcar.controller;

import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingCarGame;
import racingcar.domain.gameinfo.GameInfo;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        try {
            //GameInfo gameInfo = GameInfoGetter.carCountGame(); // 이걸로 기존 게임도 실행 가능
            GameInfo gameInfo = GameInfoGetter.carNamesGame();
            RacingCarGame game = new RacingCarGame(gameInfo);
            GameResult result = game.start();
            new ResultView().printResult(gameInfo.printWinners(), result);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "게임을 종료합니다.");
            System.exit(0);
        }
    }
}