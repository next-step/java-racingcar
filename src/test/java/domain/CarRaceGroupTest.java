package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceGroupTest {
	private CarRaceGroup carRaceGroup;

	@BeforeEach
	public void setUp() {
		carRaceGroup = new CarRaceGroup(new CarNames("BMW,KIA,HONDA"), new CarPosition("0,1,2"));
	}

	@Test
	@DisplayName("자동차 수 만큼 데이터 생성 확인")
	public void checkCarRaceMoveCount() {
		assertThat(carRaceGroup.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("이동 횟수가 입력된 이동 횟수보다 작거나 같아야 한다.")
	public void checkRandomMoveCount(){
		int indexMax = carRaceGroup.size() -1;
		assertThat(carRaceGroup.carPosition(indexMax)).isBetween(0, 3);
	}


}
