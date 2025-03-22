package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Race;

class RaceTest {
	@ParameterizedTest(name = "라운드 수 : {0}")
	@ValueSource(ints = {4, 5, 6})
	@DisplayName("입력만큼 라운드 수가 결정된다.")
	void initialRaceRoundTest(int rounds) {
		// given & when
		Race race = new Race(rounds);

		// then
		assertThat(race.getRemainingRounds())
			.isEqualTo(rounds);
	}

	@ParameterizedTest(name = "라운드 수 : {0}")
	@ValueSource(ints = {4, 5, 6})
	@DisplayName("남은 라운드를 1만큼 감소한다.")
	void reduceRoundTest(int rounds) {
		// given
		Race race = new Race(rounds);

		// when
		race.reduceRound();

		// then
		assertThat(race.getRemainingRounds()).isEqualTo(rounds - 1);
	}

	@ParameterizedTest(name = "남은 라운드 수 : {0}, 레이스 진행 가능 여부 : {1}")
	@CsvSource({
		"0, false",
		"1, true",
		"2, true",
	})
	@DisplayName("남은 라운드 수가 1 이상이면 레이스 진행 가능하고, 1보다 작으면 불가능하다.")
	void hasRemainRoundTest(int remainingRounds, boolean expected) {
		// given
		Race race = new Race(remainingRounds);

		// when
		boolean result = race.hasRemainRound();

		// then
		assertThat(result).isEqualTo(expected);
	}

}
