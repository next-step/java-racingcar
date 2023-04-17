package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3_racingcar.service.CarStatus;

public class CarStatusTest {
	
	@DisplayName("status 출력값 테스트")
	@Test
	void formatStatus() {
		int position = 5;
		String expectedStatus = "-----";
		String actualStatus = CarStatus.formatStatus(position);
		assertEquals(expectedStatus, actualStatus);
	}
}

