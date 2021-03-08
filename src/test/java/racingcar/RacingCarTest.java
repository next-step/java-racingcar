package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

	@Test
	@DisplayName("자동차 전진 테스트")
	void moveTest() {
		Car car = new Car();
		assertThat(car.getPosition()).isEqualTo(0);
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
		car.move();
		car.move();
		assertThat(car.getPosition()).isEqualTo(3);
	}

	@DisplayName("게임 생성 : 자동차 생성 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"3", "5", "10"})
	void makeCarTest(int carSize) {
		Game game = new Game();
		game.makeCar(carSize);
		assertThat(game.getCar().size()).isEqualTo(carSize);
	}

	@Test
	@DisplayName("전진 또는 멈춤 테스트")
	void moveOrStopTest() {
		Game game = new Game();
		game.makeCar(1);
		Car car = game.getCar().get(0);
		game.moveOrStop(car);
		game.moveOrStop(car);
		game.moveOrStop(car);
		game.moveOrStop(car);
		game.moveOrStop(car);
		assertThat(car.getPosition()).isBetween(0,6);
	}
}
