package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountTest {
	@DisplayName("이동량이 같은지 비교")
	@Test
	public void equalsAndHashCodeOverridingTest() {
		MoveCount moveCount = MoveCount.of(4);
		MoveCount compareMoveCount = MoveCount.of(4);

		assertThat(moveCount.equals(compareMoveCount)).isTrue();
	}
}
