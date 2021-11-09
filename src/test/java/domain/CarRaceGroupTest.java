package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceGroupTest {
	private CarRaceGroup carRaceGroup;

	@BeforeEach
	public void setUp() {
		carRaceGroup = new CarRaceGroup(new CarGroup("BMW,KIA,HONDA"), new CarRaceCount(5));
	}

	@Test
	@DisplayName("자동차 수 * 이동 횟수 만큼 데이터 생성 확인")
	public void checkCarRaceMoveCount() {
		assertThat(carRaceGroup.size()).isEqualTo(15);
	}

	@Test
	@DisplayName("랜덤이동 횟수가 입력된 이동 횟수보다 작거나 같아야 한다.")
	public void checkRandomMoveCount(){
		int indexMax = carRaceGroup.size() -1;
		assertThat(carRaceGroup.carPosition(indexMax)).isBetween(0, 5);
	}

	@Test
	@DisplayName("우승자 생성 확인")
	public void checkWinner(){
		assertThat(carRaceGroup.winner()).isNotNull();
	}

}
