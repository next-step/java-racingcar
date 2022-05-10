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

	@DisplayName("더 큰 값을 리턴")
	@Test
	public void maxReturnTest() {
		MoveCount moveCount = MoveCount.of(4);
		MoveCount target = MoveCount.of(9);

		assertThat(moveCount.max(target)).isEqualTo(new MoveCount(9));
		assertThat(target.max(moveCount)).isEqualTo(new MoveCount(9));
	}
}
