package step3.racingcarWinner;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    RacingGame racingGame = new RacingGame(inputView.carNames(),inputView.racingLap());
  }
}
