package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.Printer;

public class GameController {

  public static void main(String[] args) {
    GameController.startGame();
  }

  private static void startGame() {
    try (InputView inputView = new InputView(new Scanner(System.in))) {
      Printer.welcomeMessage();

      List<Car> cars = inputView.inputCarNames();
      int round = inputView.inputRound();

      Printer.printBlankLine();
      Printer.printResultMessage();

      Game game = new Game(new Random());
      game.start(cars, round);

      Printer.printWinner(game);
    }
  }
}
