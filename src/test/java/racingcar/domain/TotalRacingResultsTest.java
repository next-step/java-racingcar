package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalRacingResultsTest {

	@Test
	@DisplayName("마지막 move를 기준으로 moveCount가 최대인 1명의 이름을 반환해야한다")
	void finalWinnerTest() {
		RacingResults round1Result = new RacingResults(
			Arrays.asList(new RacingResult("two", 1),
				new RacingResult("one", 1),
				new RacingResult("five", 1),
				new RacingResult("four", 0),
				new RacingResult("three", 0)
			)
		);

		RacingResults round2Result = new RacingResults(
			Arrays.asList(new RacingResult("two", 1),
				new RacingResult("one", 1),
				new RacingResult("five", 2),
				new RacingResult("four", 1),
				new RacingResult("three", 0)
			)
		);

		TotalRacingResults totalRacingResults = new TotalRacingResults(Arrays.asList(round1Result, round2Result));
		List<String> winners = totalRacingResults.winners();
		assertThat(winners.size()).isEqualTo(1);
		assertThat(winners.get(0)).isEqualTo("five");
	}

	@Test
	@DisplayName("마지막 move를 기준으로 moveCount가 최대가 여러명이면 모두의 이름을 반환해야한다")
	void finalMultiWinnerTest() {
		RacingResults round1Result = new RacingResults(
			Arrays.asList(new RacingResult("two", 1),
				new RacingResult("one", 1),
				new RacingResult("five", 1),
				new RacingResult("four", 0),
				new RacingResult("three", 0)
			)
		);

		RacingResults round2Result = new RacingResults(
			Arrays.asList(new RacingResult("two", 1),
				new RacingResult("one", 1),
				new RacingResult("five", 1),
				new RacingResult("four", 1),
				new RacingResult("three", 0)
			)
		);

		RacingResults round3Result = new RacingResults(
			Arrays.asList(new RacingResult("two", 1),
				new RacingResult("one", 1),
				new RacingResult("five", 1),
				new RacingResult("four", 1),
				new RacingResult("three", 1)
			)
		);

		TotalRacingResults totalRacingResults = new TotalRacingResults(Arrays.asList(round1Result, round2Result, round3Result));
		List<String> winners = totalRacingResults.winners();
		assertThat(winners.size()).isEqualTo(5);
		assertThat(winners).containsExactly("two", "one", "five", "four", "three");
	}

	@Test
	@DisplayName("TotalRacingResults 생성자에 Null을 전달해도 빈 List로 정상적으로 생성되어야한다")
	void nullContructorTest() {
		TotalRacingResults totalRacingResults = new TotalRacingResults(null);
		List<String> winners = totalRacingResults.winners();
		assertThat(winners).isEmpty();
	}
}
