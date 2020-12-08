package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		try {
			String names = InputView.askNameOfCarToUser();
			int tryTimesToUser = InputView.askNumberOfTryTimesToUser();
			CarGroup carGroup = CarGroup.ofCarNames(names, new SimpleMovePolicy());
			RaceGameModel raceGameModel = new RaceGameModel(carGroup);
			RaceGameHistory raceGameHistory = raceGameModel.start(tryTimesToUser);
			OutputView.printDistanceStatus(raceGameHistory);
			OutputView.printRaceGameWinner(raceGameHistory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
