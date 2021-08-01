package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.NameValidationException;
import racingcar.model.RacingCar;
import racingcar.strategy.RandomlyMovableStrategy;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
	private static final int INITIAL_POSITION = 0;
	private static final int POSITION_AFTER_ONE_MOVE = 1;

	RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar("chang", () -> true);
	}

	@Test
	void AlwaysMovable_전략을_입력받았을_항상_전진가능하다() {
		racingCar.forward();
		assertThat(racingCar.getPosition()).isEqualTo(POSITION_AFTER_ONE_MOVE);
	}

	@ParameterizedTest
	@MethodSource
	void RandomlyMovable_전략을_입력받았을_때_랜덤값이_4이상_일때에만_전진가능하다(Random random, Integer expected) {
		racingCar = new RacingCar("chang", new RandomlyMovableStrategy(random));
		racingCar.forward();
		assertThat(racingCar.getPosition()).isEqualTo(expected);
	}

	private static Stream<Arguments> RandomlyMovable_전략을_입력받았을_때_랜덤값이_4이상_일때에만_전진가능하다() {
		return Stream.of(
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 0;
				}
			}, INITIAL_POSITION),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 3;
				}
			}, INITIAL_POSITION),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 4;
				}
			}, POSITION_AFTER_ONE_MOVE),
			Arguments.of(new Random() {
				@Override
				public int nextInt(int bound) {
					return 9;
				}
			}, POSITION_AFTER_ONE_MOVE)
		);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 주어진_인수를_입력받았을_때_그_수_만큼_전진하다(int forwardValue) {
		for (int i = 0; i < forwardValue; i++ ) {
			racingCar.forward();
		}
		assertThat(racingCar.getPosition()).isEqualTo(forwardValue);
	}

	@ParameterizedTest
	@ValueSource(strings = { "overfive", "changsub", "longname" })
	void 길이가_5를_초과하는_자동차이름_문자열이_주어질_때_예외가_발생한다(String carName) {
		assertThatThrownBy(() -> {
			racingCar = new RacingCar(carName, null);
		}).isInstanceOf(NameValidationException.class)
				.hasMessageContaining("자동차 이름의 길이가 5를 초과합니다");
	}
}
