public class Main {
  public static void main(String[] args) {
    String[] carNames = RacingCarGameInputView.getCarNames();
    int roundAmount = RacingCarGameInputView.getRoundAmount();

    RacingCarGame racingCarGame = new RacingCarGame(carNames, roundAmount);
    racingCarGame.play(new RandomMoveStrategy());

    RacingCarGameResultView resultView = new RacingCarGameResultView(racingCarGame);
    resultView.showResult();
  }
}
