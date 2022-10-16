package study.step5.domain.racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.car.Car;
import study.step5.domain.car.Cars;
import study.step5.exception.BadRequestException;
import study.step5.domain.movestrategy.MoveStrategy;

class RacingGameInfoTest {

	private MoveStrategy moveStrategy;
	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars(Arrays.asList(new Car("car1"), new Car("car2")));
	}

	@DisplayName("0 미만의 round 입력시 에러를 던진다.")
	@Test
	void Given_RoundUnder0_Then_ThrowException() {

		assertThatThrownBy(() ->new RacingGame(cars, -1, moveStrategy)).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("RacingGameInfo의 currentRound는 0으로 초기화된다.")
	@Test
	void Given_RoundUpper0_Then_ThrowException() {
		int result = new RacingGame(cars, 0, moveStrategy).getCurrentRound();

		assertThat(result).isEqualTo(0);
	}
}