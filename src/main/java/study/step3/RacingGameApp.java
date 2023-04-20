package study.step3;

import study.domain.racingGame.Cars;
import study.domain.racingGame.GameBoard;
import study.domain.racingGame.GameConsole;
import study.domain.racingGame.GameScreen;
import study.domain.racingGame.RacingGame;

public class RacingGameApp {

  public static void main(String[] args) {
    RacingGame game = new RacingGame();
    GameScreen screen = new GameScreen();
    GameConsole console = new GameConsole();
    screen.println("자동차 대수는 몇 대 인가요?");
    int carNum = console.inputInt();

    screen.println("시도할 회수는 몇 회 인가요?");
    int gameCnt = console.inputInt();
    Cars racingCar = new Cars(carNum);
    game.ready(gameCnt, racingCar);
    do {
      if (!game.isReady()) {
        return;
      }
      GameBoard raceBoard = game.race();
      screen.printRaceResult(racingCar, raceBoard);

    } while (!game.isFinish());
  }

}