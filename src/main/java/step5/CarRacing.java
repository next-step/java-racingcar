package step5;


import step5.domain.Cars;
import step5.view.InputView;
import step5.view.ResultView;

public class CarRacing {

	public static void main(String[] args) {
		String carsName = InputView.requestCarsName();
		int times = InputView.requestHowManyTimes();

		Cars participants = new Cars(carsName);
		for (int i = 0; i < times; i++) {
			ResultView.saveRoundResult(participants.playRound(new Always4Strategy()));
		}
		ResultView.printRacingResult();
		ResultView.printWinner(participants.findWinner());
	}

}
