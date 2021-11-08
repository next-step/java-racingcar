public class Main {
  public static void main(String[] args) {
    int carAmount = RacingCarGameInputView.getCarAmount();
    int chanceAmount = RacingCarGameInputView.getChanceAmount();

    RacingCarGame racingCarGame = new RacingCarGame(carAmount, chanceAmount);
    racingCarGame.play(new RandomMoveStrategy());

    RacingCarGameResultView resultView = new RacingCarGameResultView(racingCarGame);
    resultView.showResult();
  }
}
