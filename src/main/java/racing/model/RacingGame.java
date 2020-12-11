package racing.model;

public class RacingGame {

	private final RacingCars racingCars;

	public RacingGame(String[] names) {

		this.racingCars = new RacingCars(names);
	}

	public void start() {

		this.racingCars.start();
	}

	public RacingCars getRacingCars() {

		return this.racingCars;
	}

	public String getWinner() {
		
		return this.racingCars.getWinnerNames();
	}
}
