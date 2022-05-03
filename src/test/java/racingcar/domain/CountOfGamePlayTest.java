package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountOfGamePlayTest {

	@DisplayName("게임을 한라운드 진행 시 count 1 감소")
	@Test
	public void reduceCountTest() {
		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(5);

		countOfGamePlay.race(
			RacingCars.of(new CarNames("zieun,poby")),
			new EngineRandomStrategy());

		assertThat(countOfGamePlay).isEqualTo(new CountOfGamePlay(4));
	}
}
