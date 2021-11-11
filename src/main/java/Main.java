public class Main {
  public static void main(String[] args) {
    String[] carNames = RacingCarGameInputView.inputCarNames();
    int roundAmount = RacingCarGameInputView.inputRoundAmount();

    RacingCarGame racingCarGame = new RacingCarGame(carNames, roundAmount);
    racingCarGame.play(new RandomMoveStrategy());
    
    RacingCarGameResultView resultView = new RacingCarGameResultView(racingCarGame.getResults());
    resultView.showResult();
  }
}
