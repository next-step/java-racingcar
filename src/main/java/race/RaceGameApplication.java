package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		RaceGameController raceGameController = new RaceGameController(new RandomMovePolicy());
		new OutputView(raceGameController);
		raceGameController.start();
	}
}
