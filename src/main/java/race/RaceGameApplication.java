package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		try {
			String names = InputView.askNameOfCarToUser();
			int tryTimesToUser = InputView.askNumberOfTryTimesToUser();
			RaceGameFactory raceGameFactory = new RandomRaceGameFactory(names, tryTimesToUser);
			RaceGameHistory history = raceGameFactory.start();
			OutputView.printDistanceStatus(history);
			OutputView.printRaceGameWinner(history);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
