package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceGroupTest {
	private CarRaceGroup carRaceGroup;

	@BeforeEach
	public void setUp() {
		carRaceGroup = new CarRaceGroup(new CarNames("BMW,KIA,HONDA"));
	}

	@Test
	@DisplayName("자동차 수 만큼 기초 데이터 생성 확인")
	public void checkCarRaceMoveCount() {
		assertThat(carRaceGroup.size()).isEqualTo(3);
	}

}
