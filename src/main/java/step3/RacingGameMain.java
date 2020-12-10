package step3;

import step3.view.RacingGameInputView;

public class RacingGameMain {
  public static void main(String[] args) {
    String carNames = RacingGameInputView.getCarNamesFromUser();
    int gameCount = RacingGameInputView.getGameCountFromUser();

    System.out.println("실행결과");
    RacingGame game = new RacingGame(carNames, gameCount);
    game.race();
  }
}
