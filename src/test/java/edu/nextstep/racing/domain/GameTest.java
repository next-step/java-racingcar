package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Game : 인스턴스 변수인 자동차목록과 이동횟수를 사용해 게임을 play 시킴")
class GameTest {

	@DisplayName("play : 자동차 게임을 1회 진행함. 참가한 모든 자동차들의 위치가 전략에 따라 1 또는 0 증가하여야 함.")
	@Test
	void play() {
		Car car1 = new Car("pobi", 1, Car.ALWAYS_MOVE_STRATEGY);
		Car car2 = new Car("crong", 2, Car.ALWAYS_MOVE_STRATEGY);
		Car car3 = new Car("honux", 3, Car.NEVER_MOVE_STRATEGY);
		Game game = new Game(Arrays.asList(car1, car2, car3), 5);
		game.play();
		assertThat(game.getCars().getAll().get(0).getLocation()).isEqualTo(new Location(2));
		assertThat(game.getCars().getAll().get(1).getLocation()).isEqualTo(new Location(3));
		assertThat(game.getCars().getAll().get(2).getLocation()).isEqualTo(new Location(3));
	}
}