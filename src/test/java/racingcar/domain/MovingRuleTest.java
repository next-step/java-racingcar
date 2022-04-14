package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.OutOfRangeException;

public class MovingRuleTest {

	@DisplayName("랜덤값이 4미만이면 이동하지 않는다.")
	@ValueSource(ints = {0,1,2,3})
	@ParameterizedTest
	public void When_lessThan4_Expected_0(int randomNumber) {
		// given
		RandomMovingRule randomMovingRule = new RandomMovingRule(() -> randomNumber);

		// when
		boolean isMoveCar = randomMovingRule.isMoveCar();

		// then
		assertThat(isMoveCar).isEqualTo(false);
	}

	@DisplayName("랜덤값이 4이상이면 이동한다.")
	@ValueSource(ints = {4,5,6,7,8,9})
	@ParameterizedTest
	public void When_moreThanOrEqual4_Expected_1(int randomNumber) {
		// given
		RandomMovingRule randomMovingRule = new RandomMovingRule(() -> randomNumber);

		// when
		boolean isMoveCar = randomMovingRule.isMoveCar();

		// then
		assertThat(isMoveCar).isEqualTo(true);
	}

	@DisplayName("랜덤이 범위를 벗어나면 RunTimeException발생")
	@ValueSource(ints = {-1,10})
	@ParameterizedTest
	public void When_RandomNumberIsOutOfRange_Expected_RunTimeException(int randomNumber) {
		// given
		RandomMovingRule randomMovingRule = new RandomMovingRule(() -> randomNumber);

		// when, then
		assertThatThrownBy(randomMovingRule::isMoveCar)
			.isInstanceOf(OutOfRangeException.class);
	}
}
