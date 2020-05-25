package step3;

public class Main {
  public static void main(String[] args) {
    Game racingGame = new RacingGame(RacingGameInput.getNumberOfCarsByScanner(),
        RacingGameInput.getTimeByScanner());

    racingGame.play();
  }
}
