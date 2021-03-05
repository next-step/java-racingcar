package racingcar;

import java.util.Scanner;
import racingcar.io.InputView;
import racingcar.io.Printer;

public class GameManager {

  public static void main(String[] args) {
    GameManager.startGame();
  }

  private static void startGame() {
    try (InputView inputView = new InputView(new Scanner(System.in))) {
      Printer.welcomeMessage();
    }
  }
}
