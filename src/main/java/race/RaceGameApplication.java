package race;

import race.domain.RaceGameFactory;
import race.domain.RaceGameResult;
import race.domain.RandomRaceGameFactory;
import race.view.InputView;
import race.view.OutputView;

public class RaceGameApplication {

	public static void main(String[] args) {
		try {
			String names = InputView.askNameOfCarToUser();
			int tryTimesToUser = InputView.askNumberOfTryTimesToUser();
			RaceGameFactory raceGameFactory = new RandomRaceGameFactory(names, tryTimesToUser);
			RaceGameResult gameResult = raceGameFactory.start();
			OutputView.printDistanceStatus(gameResult);
			OutputView.printRaceGameWinner(gameResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
