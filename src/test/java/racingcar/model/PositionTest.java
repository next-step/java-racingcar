package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {
	@DisplayName("increase() 호출시에 포지션 변경 검증")
	@ParameterizedTest(name = "{index}. countOfIncrease : {0}, expectedPosition : {1}")
	@CsvSource({"1,1", "5,5", "9,9"})
	void increase(int countOfIncrease, int expectedPosition) {
		// given
		Position position = Position.create();

		// when
		for (int i = 0; i < countOfIncrease; i++) {
			position.increase();
		}

		// then
		assertThat(position).isEqualTo(new Position(expectedPosition));
	}

	@DisplayName("compareTo() 호출시 포지션 비교 검증")
	@ParameterizedTest(name = "{index}. position : {0}, otherPosition : {1}, expected : {2}")
	@CsvSource({"10,1,1", "1,1,0", "1,10,-1"})
	void compareTo(int position, int otherPosition, int expected) {
		// given
		Position givenPosition = new Position(position);
		Position givenOtherPosition = new Position(otherPosition);

		// when
		int result = givenPosition.compareTo(givenOtherPosition);

		// then
		assertThat(result).isEqualTo(expected);
	}
}
