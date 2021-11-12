package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarStatusTest {

	private Cars cars;
	private Game game;

	@BeforeEach
	void setValue(){
		int carCount = 5;
		cars = new Cars();
		cars.createCar(carCount);

		int gameCount = 10;
		game = new Game();
		game.createGameCount(gameCount);
	}

	@Test
	@DisplayName("게임 시작")
	void getGameStatus() {
		GameStatus status = new GameStatus(cars, game);
		status.startRacing();
	}
}
