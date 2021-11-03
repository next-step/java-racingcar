package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {
	@DisplayName("마지막 라운드일때 hasNext() 호출시 False 리턴 검증")
	@ParameterizedTest(name = "{index}. currentRound : {0}, endRound : {1}")
	@CsvSource({"10,9", "5,4", "3,2"})
	void hasNext(int currentRound, int endRound) {
		// given
		Round round = new Round(currentRound, endRound);

		// when
		boolean result = round.hasNext();

		// then
		assertThat(result).isFalse();
	}

	@DisplayName("increase() 호출시에 Round 증가 검증")
	@ParameterizedTest(name = "{index}. endRound : {0}, countOfIncrease : {1}, currentRound : {2}")
	@CsvSource({"10,3,4", "10,5,6", "10,7,8"})
	void increase(int endRound, int countOfIncrease, int currentRound) {
		// given
		Round round = Round.create(endRound);

		// when
		for (int i = 0; i < countOfIncrease; i++) {
			round.increase();
		}

		// then
		assertThat(round).isEqualTo(new Round(currentRound, endRound));
	}
}
