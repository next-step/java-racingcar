package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	//자동차 갯수
	//게임 실행 횟수

	@Test
	@DisplayName("자동차 갯수 테스트")
	void getCarCount() {
		int carCount = 5;
		Cars cars = new Cars();
		cars.createCar(carCount);
		assertThat(cars.carCount()).isEqualTo(carCount);
	}

	@Test
	@DisplayName("게임 실행 횟수")
	void getGameCount() {
		int gameCount = 10;
		Game game = new Game();
		game.createGameCount(gameCount);
		assertThat(game.countGame()).isEqualTo(gameCount);
	}

}
