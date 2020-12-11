package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryRaceNumberTest {

	@Test
	@DisplayName("주행 횟수 객체 생성 테스트")
	void initTryRaceNumTest() {

		TryRaceNumber tryNumber = new TryRaceNumber("65");
	}
}
