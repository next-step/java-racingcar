package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceCountTest {
	@Test
	@DisplayName("자동차 경주 회수 생성")
	public void numberOfCarRace() {
		CarRaceCount carRaceCount = new CarRaceCount(5);
		assertThat(carRaceCount.count()).isEqualTo(5);
	}

}