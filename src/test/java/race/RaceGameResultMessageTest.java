package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameResultMessageTest {

	@DisplayName("가장 거리를 멀리간 자동차 결과 테스트")
	@Test
	void 가장_거리를_멀리간_자동차_결과_메세지_TEST() {
		RaceGameFactory raceGameFactory = new SimpleRaceGameFactory("pobi,hglee", 5);
		RaceGameHistory raceGameHistory = raceGameFactory.start();

		assertThat(raceGameHistory.getDistanceWinner()).isEqualTo("pobi,hglee");

	}
}
