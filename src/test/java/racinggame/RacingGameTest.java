package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@DisplayName("랜덤함수 테스트")
	@Test
	void getRandomValue() {
		assertThat(IntStream.rangeClosed(0, 9)
								.anyMatch(i -> i == RandomValueUtil.getRandomValue()))
			.isTrue();
	}
}
