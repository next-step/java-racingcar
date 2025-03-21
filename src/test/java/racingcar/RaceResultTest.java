package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.CarInfo;
import racingcar.domain.RaceResult;

class RaceResultTest {

	@Test
	@DisplayName("가장 멀리 간 자동차의 위치를 반환한다.")
	void findMaxLocationTest() {
		// given
		List<CarInfo> carInfo = List.of(new CarInfo("pobi", 3),
			new CarInfo("pobi", 2),
			new CarInfo("pobi", 1));

		// when
		int maxLocation = RaceResult.findMaxLocation(carInfo);

		// then
		assertThat(maxLocation).isEqualTo(3);
	}

	@Test
	@DisplayName("가장 멀리 간 사람이 우승자가 된다.")
	void determineWinnerTest() {
		// given
		List<CarInfo> carInfo = List.of(new CarInfo("pobi", 3),
			new CarInfo("pobi", 2),
			new CarInfo("pobi", 1));

		// when
		List<String> winners = RaceResult.determineWinner(carInfo);

		// then
		assertThat(winners).contains("pobi");
		assertThat(winners).doesNotContain("crong", "honux");
	}

}
