package study.racingcar;

public class GameStatus {
	private final Cars cars;
	private final Game game;

	public GameStatus(Cars cars, Game game) {
		this.cars = cars;
		this.game = game;
	}

	public void startRacing() {
		for (int i = 0; i < game.countGame(); i++) {
			cars.goRace();
			System.out.println();
		}
	}
}
