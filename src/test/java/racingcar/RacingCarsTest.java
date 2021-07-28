package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.exception.OverFiveCarNameException;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.strategy.AlwaysMovableStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RacingCarsTest {
	RacingCars racingCars;

	@BeforeEach
	void setUp() throws OverFiveCarNameException {
		racingCars = new RacingCars(3, new AlwaysMovableStrategy());
	}


	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 4 })
	void 생성자를_호출하였을_때_초기값_0으로_위치값이_세팅된다(int carNum) throws OverFiveCarNameException {
		racingCars = new RacingCars(carNum, new AlwaysMovableStrategy());
		racingCars.getCars().stream().forEach(racingCar -> {
			assertThat(racingCar.getRacingCarDashString()).isEqualTo("");
		});
	}

	@Test
	void 모든_자동차들의_전진함수가_호출된다면_모든_자동차들은_한_칸씩_전진한다() {
		racingCars.getCars().stream()
			.forEach(racingCar -> {
				racingCar.forward();
			});

		for (int i = 0; i < 3 ; i++) {
			assertThat(racingCars.getCars().get(i).getRacingCarDashString()).isEqualTo("-");
		}
	}


	@ParameterizedTest
	@MethodSource
	void 전진횟수와_자동차이름이_주어지고_항상전진전략을_가지는_자동차그룹이_있을때_우승자를_예측한다(
			String[] carNames, Integer[] forwardIterationNumber, String expected
	) throws OverFiveCarNameException {
		racingCars = new RacingCars(carNames, new AlwaysMovableStrategy());
		for (int i = 0; i < carNames.length ; i++) {
			iterateForward(racingCars.getCars().get(i), forwardIterationNumber[i]);
		}

		String winners = racingCars.getWinners().toString();
		System.out.println(winners);
		assertThat(winners.substring(1, winners.length() - 1)).isEqualTo(expected);
	}

	private static void iterateForward(RacingCar racingCar, int iterationCount) {
		for(int i = 0; i < iterationCount; i++) {
			racingCar.forward();
		}
	}

	private static Stream<Arguments> 전진횟수와_자동차이름이_주어지고_항상전진전략을_가지는_자동차그룹이_있을때_우승자를_예측한다() {
		return Stream.of(
				Arguments.of(
						new String[] {"chang", "sub", "kwak"},
						new Integer[] {3, 5, 3},
						"sub"
				),
				Arguments.of(
						new String[] {"pobi", "crong", "honux"},
						new Integer[] {5, 5, 3},
						"pobi, crong"
				),
				Arguments.of(
						new String[] {"red", "green", "blue"},
						new Integer[] {5, 5, 5},
						"red, green, blue"
				)
		);
	}
}
