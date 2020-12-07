package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingResultsTest {

	@Test
	@DisplayName("moveCount가 최대인 1명의 이름을 반환해야한다")
	void singleWinnerTest() {
		RacingResults results = new RacingResults(
			Arrays.asList(new RacingResult("two", 2),
				new RacingResult("one", 1),
				new RacingResult("five", 5),
				new RacingResult("four", 4),
				new RacingResult("three", 3)
			)
		);

		List<String> winners = results.winners();
		assertThat(winners.size()).isEqualTo(1);
		assertThat(winners.get(0)).isEqualTo("five");
	}

	@Test
	@DisplayName("moveCount가 최대인 사람이 여럿이면 모두의 이름을 반환해야한다")
	void multipleWinnerTest() {
		RacingResults results = new RacingResults(
			Arrays.asList(new RacingResult("two", 3),
				new RacingResult("one", 1),
				new RacingResult("five", 3),
				new RacingResult("four", 2),
				new RacingResult("three", 0)
			)
		);
		List<String> winners = results.winners();
		assertThat(winners.size()).isEqualTo(2);
		assertThat(winners).containsExactly("two", "five");
	}
}
