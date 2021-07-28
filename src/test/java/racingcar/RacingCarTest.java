package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.exception.OverFiveCarNameException;
import racingcar.model.RacingCar;
import racingcar.strategy.AlwaysMovableStrategy;
import racingcar.strategy.RandomlyMovableStrategy;

import java.util.Random;
import java.util.stream.Stream;

class RacingCarTest {
	RacingCar racingCar;

	public static RandomlyMovableStrategy getRandomMovableStrategyByRandomObject(Random random) {
		return new RandomlyMovableStrategy(random);
	}

	@BeforeEach
	void setUp() throws OverFiveCarNameException {
		racingCar = new RacingCar("chang", new AlwaysMovableStrategy());
	}

	@Test
	void AlwaysMovable_전략을_입력받았을_항상_전진가능하다() {
		racingCar.forward();
		assertThat(racingCar.getRacingCarDashString()).isEqualTo("-");
	}

	@ParameterizedTest
	@MethodSource
	void RandomlyMovable_전략을_입력받았을_때_랜덤값이_4이상_일때에만_전진가능하다(Random random, String expected) throws
		OverFiveCarNameException {
		racingCar = new RacingCar("chang", getRandomMovableStrategyByRandomObject(random));
		racingCar.forward();
		assertThat(racingCar.getRacingCarDashString()).isEqualTo(expected);
	}

	private static Stream<Arguments> RandomlyMovable_전략을_입력받았을_때_랜덤값이_4이상_일때에만_전진가능하다() {
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

	@ParameterizedTest
	@ValueSource(strings = { "overfive", "changsub", "longname" })
	void 길이가_5를_초과하는_자동차이름_문자열이_주어질_때_예외가_발생한다(String carName) {
		assertThatThrownBy(() -> {
			racingCar = new RacingCar(carName, null);
		}).isInstanceOf(OverFiveCarNameException.class)
				.hasMessageContaining("자동차 이름의 길이가 5를 초과합니다");
	}

	// @ParameterizedTest
	// @ValueSource(strings = { "five", "chang", "long" })
	// void 길이가_5이하의_자동차이름_문자열이_주어질_때_예외가_발생하지_않는다(String carName) {
	// 	assertDoesNotThrow(() -> {
	// 		racingCar = new RacingCar(carName, null);
	// 	});
	// }
}
