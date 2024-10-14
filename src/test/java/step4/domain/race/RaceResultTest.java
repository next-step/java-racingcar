package step4.domain.race;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.domain.race.RaceResult.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {
	private final static int WIN_POSITION = 1;
	private final static int ZERO_POSITION = 0;
	private final static String WINNER_1 = "WINNER_1";
	private final static String WINNER_2 = "WINNER_2";
	private final static String LOSER_1 = "LOSER_1";
	private final static String LOSER_2 = "LOSER_2";

	private List<String> winners;
	private Map<String, Integer> endResult;

	@BeforeEach
	void setUp() {
		endResult = makeEndResult();
		winners = getWinners(endResult, WIN_POSITION);
	}

	private Map<String, Integer> makeEndResult() {
		Map<String, Integer> result = new HashMap<>();
		result.put(WINNER_1, WIN_POSITION);
		result.put(WINNER_2, WIN_POSITION);
		result.put(LOSER_1, ZERO_POSITION);
		result.put(LOSER_2, ZERO_POSITION);
		return result;
	}

	@Test
	@DisplayName("최종 position이 제일 높은 사람을 우승자로 뽑는 기능 테스트.")
	void getWinnerTest() {
		assertThat(winners.size()).isNotEqualTo(0);
		for (String winner : winners) {
			assertThat(winner).isIn(WINNER_1, WINNER_2);
		}
	}

	@Test
	@DisplayName("position이 제일 높은 사람이 두명 이상일 때 동시 우승자로 뽑는 기능 테스트 (참여자 전부 동시 우승)")
	void getMultipleWinnerTest() {
		assertThat(getWinners(endResult, WIN_POSITION).size()).isEqualTo(2);
		for (String winner : winners) {
			assertThat(winner).isIn(WINNER_1, WINNER_2);
		}
	}
}