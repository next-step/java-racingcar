package step5.stretegy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.stretegy.BoundedDice;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BoundedDiceTest {

	@DisplayName("10만번 random 값을 뽑는 것 모두 0 ~ bound -1 사이의 값이어야 한다.")
	@ParameterizedTest
	@CsvSource(value = {"10:0:9", "5:0:4"}, delimiter = ':')
	void attemptMove(int bound, int min, int max) {
		int givenStart = 0;
		int givenEnd = 100000;
		BoundedDice boundedDice = new BoundedDice(bound);

		IntStream.range(givenStart,givenEnd).forEach(index -> assertThat(boundedDice.rollDice()).isBetween(min,max));
	}

}