package racingCar;

import java.util.List;
import racingCar.game.GameResult;
import racingCar.game.RacingCarGame;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    resultView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    List<String> carNames = StringUtil.splitComma(inputView.inputString());

    resultView.print("시도할 회수는 몇 회 인가요?");
    int gameTryNum = inputView.inputInteger();

    RacingCarGame racingCarGame = new RacingCarGame(carNames);

    GameResult gameResult = racingCarGame.playGames(gameTryNum);
    showGameResult(resultView, gameResult);
  }

  private static void showGameResult(ResultView resultView, GameResult gameResult){
    resultView.print("실행 결과");
    for (String result : gameResult.getRoundResults()) {
      resultView.print(result);
    }
    resultView.printWinnerMessage(gameResult.getWinners());
  }


}
