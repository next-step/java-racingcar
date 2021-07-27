package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.model.RacingCar;
import racingcar.strategy.AlwaysMovableStrategy;
import racingcar.strategy.RandomlyMovableStrategy;

import java.util.Random;
import java.util.stream.Stream;

class RacingCarTest {
	RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar(new AlwaysMovableStrategy());
	}

	@Test
	void AlwaysMovable_전략을_입력받았을_항상_전진가능하다() {
		racingCar.forward();
		assertThat(racingCar.getRacingCarDashString()).isEqualTo("-");
	}

	@ParameterizedTest
	@MethodSource
	void RandomlyMovable_전략을_입력받았을_때_랜덤값이_4이상_일때에만_전진가능하다(Random random, String expected) {
		racingCar = new RacingCar(RandomlyMovableStrategy.initRandomSeed(random));
		racingCar.forward();
		assertThat(racingCar.getRacingCarDashString()).isEqualTo(expected);
	}

	private static Stream<Arguments> RandomlyMovable_전략을_입력받았을_때_랜덤값에_따라_전진가능하다() {
		return Stream.of(
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 0;
				}
			}, ""),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 3;
				}
			}, ""),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 4;
				}
			}, "-"),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 9;
				}
			}, "-")
		);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 주어진_인수를_입력받았을_때_그_수_만큼_전진하다(int forwardValue) {
		for (int i = 0; i < forwardValue; i++ ) {
			racingCar.forward();
		}
		assertThat(racingCar.getRacingCarDashString()).isEqualTo(new String(new char[forwardValue]).replace("\0", "-"));
	}

}
