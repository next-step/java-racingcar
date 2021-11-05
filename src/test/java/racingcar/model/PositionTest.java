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
}