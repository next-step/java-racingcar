package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Playground : Game과 Car 객체를 엮어, 실제 Game이 세팅되고 Play될 수 있도록 함.")
class PlaygroundTest {

	@DisplayName("createGameCars : 자동차 대수를 파라미터로 받아 동일한 사이즈의 자동차 객체 목록을 생성하여 리턴해야 함.")
	@Test
	void createGameCars() {
		int numberOfCars = 3;
		List<Car> gameCars = new Playground().createGameCars(numberOfCars);
		assertThat(gameCars).hasSize(3);
	}

	@DisplayName("createRacingGame : 파라미터로 넘겨준 만큼의 자동차 대수와 이동 시도 횟수를 가지는 새 게임을 생성해 리턴해야 함")
	@Test
	void createRacingGame() {
		int numberOfCars = 3;
		int moveTryMaxCount = 5;
		assertThat(new Playground().createRacingGame(numberOfCars, moveTryMaxCount))
			.isNotNull()
			.satisfies(game -> {
				assertThat(game.getGameCars()).hasSize(numberOfCars);
				assertThat(game.getMoveTryMaxCount()).isEqualTo(moveTryMaxCount);
			});
	}
}