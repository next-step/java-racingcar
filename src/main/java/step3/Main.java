package step3;

public class main {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame();

    game.setNumberOfCars();
    game.setNumberOfReps();
    game.setCarsReady();

    game.startRacing();
  }
}
