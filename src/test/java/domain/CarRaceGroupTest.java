package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceGroupTest {
	private CarRaceGroup carRaceGroup;

	@BeforeEach
	public void setUp(){
		carRaceGroup = new CarRaceGroup(new CarCount(3), new CarRaceCount(5));
	}

	@Test
	@DisplayName("시도 횟수만큼 이동 데이터 생성")
	public void createCarMoveList(){
		assertThat(carRaceGroup.size()).isEqualTo(5);
	}
	
	@Test
	@DisplayName("시도 횟수별 자동차 수 확인")
	public void checkCarCountByMoving(){
		assertThat(carRaceGroup.carCountByMoving(0)).isEqualTo(3);
		assertThat(carRaceGroup.carCountByMoving(1)).isEqualTo(3);
		assertThat(carRaceGroup.carCountByMoving(2)).isEqualTo(3);
		assertThat(carRaceGroup.carCountByMoving(3)).isEqualTo(3);
		assertThat(carRaceGroup.carCountByMoving(4)).isEqualTo(3);
	}
}