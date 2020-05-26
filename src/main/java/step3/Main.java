package step3;

public class Main {
  public static void main(String[] args) {
    Game racingGame = new RacingGame(RacingGameInput.getNameOfCarsByScanner(),
        RacingGameInput.getTimeByScanner());

    racingGame.play();
  }
}
