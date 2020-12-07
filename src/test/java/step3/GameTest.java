package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Game : 자동차 게임을 진행함에 필요한 상태들을 가지고 있고, 게임을 진행하는 등의 역할을 수행함.")
class GameTest {

	@Order(1)
	@DisplayName("getGameCars : 자동차 게임에 참가한 자동차들 목록을 가져옴.")
	@Test
	void getGameCars() {
		List<Car> gameCars = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 5;
		assertThat(new Game(gameCars, 5).getGameCars()).isEqualTo(gameCars);
	}

	@Order(2)
	@DisplayName("getMoveTryMaxCount : 자동차 게임에서 총 몇 번의 이동을 할 것인지 횟수를 구함.")
	@Test
	void getMoveTryMaxCount() {
		List<Car> entry = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 5;
		assertThat(new Game(entry, 5).getMoveTryMaxCount()).isEqualTo(5);
	}

	@Order(3)
	@DisplayName("tryToMoveAllGameCars : 자동차 게임에 참가한 모든 자동차들의 위치가 1 또는 0 증가하여야 함.")
	@Test
	void tryToMoveAllGameCars() {
		List<Car> entry = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 5;
		Game game = new Game(entry, moveTryMaxCount);
		game.tryToMoveAllGameCars();
		assertThat(entry).allSatisfy(car ->
			assertThat(car.getLocation())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(1)
		);
	}

	@Order(4)
	@DisplayName("play : 자동차 게임을 1회 진행함. 참가한 모든 자동차들은 위치가 0 이상 누적 이동횟수 이하여여 함.")
	@Test
	void play() {
		List<Car> entry = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 5;
		Game game = new Game(entry, moveTryMaxCount);
		game.play();
		assertThat(entry).allSatisfy(car ->
			assertThat(car.getLocation())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(1)
		);
	}

	@Order(5)
	@DisplayName("isContinue : 현재까지 누적 이동 횟수가 Game에 사전 설정된 최대 이동횟수를 넘지 않으면 true를 리턴함.")
	@Test
	void isContinue() {
		List<Car> entry = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 3;
		Game game = new Game(entry, moveTryMaxCount);
		game.play();
		assertThat(game.isContinue()).isTrue();
		game.play();
		assertThat(game.isContinue()).isTrue();
		game.play();
		assertThat(game.isContinue()).isFalse();
	}

	@Order(6)
	@DisplayName("play와 isContinue : 자동차 게임을 끝까지 진행함. 참가한 모든 자동차들은 위치가 0 이상 최대 이동 시도 횟수 이하여여 함.")
	@Test
	void playToEnd() {
		List<Car> entry = Arrays.asList(new Car(), new Car(), new Car());
		int moveTryMaxCount = 5;
		Game game = new Game(entry, moveTryMaxCount);
		while (game.isContinue()) {
			game.play();
			assertThat(entry).allSatisfy(car ->
				assertThat(car.getLocation())
					.isGreaterThanOrEqualTo(0)
					.isLessThanOrEqualTo(moveTryMaxCount)
			);
		}
	}
}