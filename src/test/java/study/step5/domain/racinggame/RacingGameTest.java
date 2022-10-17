package study.step5.domain.racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.car.Car;
import study.step5.domain.car.Cars;
import study.step5.domain.movestrategy.MoveStrategy;
import study.step5.domain.movestrategy.RandomMoveStrategy;

class RacingGameTest {

	@DisplayName("racing game의 현재 라운드 값은 0으로 초기화된다")
	@Test
	void Given_InitRacingGame_Then_CurrentRoundIsZero() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Cars cars = new Cars(Arrays.asList(car1, car2));

		RacingGame racingGame = new RacingGame(cars, 2, new RandomMoveStrategy());
		assertThat(racingGame.getCurrentRound()).isEqualTo(0);
	}

	@DisplayName("winners의 위치는 최대 위치와 갖는다.")
	@Test
	void Given_Cars_Then_ReturnCarHasMaxPosition() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Cars cars = new Cars(Arrays.asList(car1, car2));

		RacingGame racingGame = new RacingGame(cars, 2, new RandomMoveStrategy());

		MoveStrategy moveStrategy = () -> true;
		car1.move(moveStrategy);

		Cars winners = racingGame.findWinners();
		winners.forEach(winner -> assertThat(winner.getPosition()).isEqualTo(1));
	}
}