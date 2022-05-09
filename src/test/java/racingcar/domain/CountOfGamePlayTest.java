package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountOfGamePlayTest {

	@DisplayName("게임을 한라운드 진행 시 count 1 감소")
	@Test
	public void reduceCountTest() {
		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(5);

		countOfGamePlay.race();
		countOfGamePlay.race();

		assertThat(countOfGamePlay).isEqualTo(new CountOfGamePlay(3));
	}

	@DisplayName("게임이 더이상 진행 가능한지 확인")
	@Test
	public void canPlayGameTest() {
		assertThat(new CountOfGamePlay(1).racing()).isTrue();
		assertThat(new CountOfGamePlay(0).racing()).isFalse();
	}
}
