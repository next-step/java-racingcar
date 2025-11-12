package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	@DisplayName("자동차의 초기 위치는 0이다")
	void returnZero_WhenInitialized() {
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("자동차는 0부터 9까지의 수 중에서 4 이상인 수를 받으면 전진한다")
	void moveForward_WhenNumberIsFourOrMore(
		int expected
	) {
		// Arrange
		int position = car.getPosition();

		// Act
		car.move(expected);

		// Assert
		assertThat(car.getPosition()).isEqualTo(position + 1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("자동차는 0부터 9까지의 수 중에서 4 미만인 수를 받으면 멈춘다")
	void doNotMove_WhenNumberIsLessThanFour(
		int expected
	) {
		// Arrange
		int position = car.getPosition();

		// Act
		car.move(expected);

		// Assert
		assertThat(car.getPosition()).isEqualTo(position);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("자동차가 전진하지 않았을 때 빈 문자열을 반환한다")
	void returnEmptyString_WhenNotMoved(
		int expected
	) {
		car.move(expected);

		// Assert
		assertThat(car.move(expected)).isEqualTo("");
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("자동차가 전진했을 때 위치에 해당하는 개수만큼 '-'를 반환한다")
	void returnDashes_WhenMoved(
		int expected
	) {
		// TODO
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("자동차가 여러 번 전진하면 전진한 횟수만큼 위치가 증가한다")
	void addPosition_WhenMovedMultipleTimes(
		int moveCount
	) {
		// TODO
	}
}
