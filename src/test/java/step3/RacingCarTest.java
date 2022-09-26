package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	@DisplayName("레이싱 참가자 수 테스트")
	public void participantOfRacing() throws Exception {
		int actual = Racing.participate("3");
		assertThat(actual).isEqualTo(3);
	}
}
