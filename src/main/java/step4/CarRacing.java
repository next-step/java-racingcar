package step4;

public class CarRacing {

	public static void main(String[] args) {
		String carsName = InputView.requestCarsName();
		int times = InputView.requestHowManyTimes();

		Cars participants = new Cars(carsName);

		for (int i = 0; i < times; i++) {
			ResultView.saveRoundResult(Round.play(participants));
		}
		ResultView.printRacingResult();
		ResultView.printWinner(participants.findWinner());
	}

}
