package step3;

public class Main {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame();

    game.getCarsReady();
    game.getRepetitionReady();

    game.startRacing();
  }
}
