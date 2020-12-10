package step3;

public class RacingCarGameClient {
	public static void main(String[] args) {
		int carNumber = InputView.waiteInputCarCount();
		int tryNumber = InputView.waiteInputTryCount();

		ResultView.printResult(new RacingCarGame(carNumber, tryNumber).play());
	}
}
