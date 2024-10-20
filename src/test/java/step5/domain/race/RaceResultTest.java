package step5.domain.race;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5.domain.car.Position;

class RaceResultTest {
	private final static Position WIN_POSITION = new Position(1);
	private final static Position ZERO_POSITION = new Position(0);
	private final static String WINNER_1 = "WINNER_1";
	private final static String WINNER_2 = "WINNER_2";
	private final static String LOSER_1 = "LOSER_1";
	private final static String LOSER_2 = "LOSER_2";

	private CarPositionMap makeEndResult() {
		CarPositionMap result = new CarPositionMap();
		result.writeCarPosition(WINNER_1, WIN_POSITION);
		result.writeCarPosition(WINNER_2, WIN_POSITION);
		result.writeCarPosition(LOSER_1, ZERO_POSITION);
		result.writeCarPosition(LOSER_2, ZERO_POSITION);
		return result;
	}

	@Test
	@DisplayName("position이 제일 높은 사람이 두명 이상일 때 동시 우승자로 뽑는 기능 테스트 (참여자 전부 동시 우승)")
	void getMultipleWinnerTest() {
		CarPositionMap endResult = makeEndResult();
		List<String> winners = endResult.getCurrentWinnerName();
		assertThat(winners.toArray()).contains(WINNER_1, WINNER_2);
	}
}