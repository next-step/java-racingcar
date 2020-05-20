package racingGameTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingGame.domain.FixedDriveOnRacingCar;
import racingGame.domain.DriveOnRacingCar;

class MovableTest {
	DriveOnRacingCar movable;
	
	@Test
	@DisplayName("이동 가능 여부 테스트(false)")
	public void immovableTest() {
		movable = new FixedDriveOnRacingCar(3);
		assertThat(movable.checkDriveOnRacingCar()).isEqualTo(false);
	}

	@Test
	@DisplayName("이동 가능 여부 테스트(true)")
	public void movableTest() {
		movable = new FixedDriveOnRacingCar(4);
		assertThat(movable.checkDriveOnRacingCar()).isEqualTo(true);
	}
}
