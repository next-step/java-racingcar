package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		try {
			RaceGameController raceGameController = new RaceGameController(new RandomMovePolicy());
			new OutputView(raceGameController);
			raceGameController.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
