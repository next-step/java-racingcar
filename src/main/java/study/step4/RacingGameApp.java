package study.step4;

import study.domain.racingGame.CarNames;
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

    screen.printCarNameInputText();
    String[] inputCarNames = console.inputCarNames();

    screen.printCarMoveCountInputText();
    int gameCnt = console.inputInt();

    CarNames carNames = new CarNames(inputCarNames);
    Cars racingCar = new Cars(carNames);
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
