package nextstep.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
	private RacingCar underTest = new RacingCar(0);

	@Test
	@DisplayName("이동가능한 수는 0보다 커야 한다.")
	public void moveCountOverZero() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.move(-2))
				.withMessage("움직일 수 있는 숫자는 0보다 크고 9보다 작아야 합니다.");
	}

	@Test
	@DisplayName("이동가능한 수는 10보다 작아야 한다.")
	public void moveCountUnderTen() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.move(10))
				.withMessage("움직일 수 있는 숫자는 0보다 크고 9보다 작아야 합니다.");
	}

	@Test
	@DisplayName(("4 이상이 이동한다."))
	public void moveTest() {
		underTest.move(5);
		assertThat(underTest.getPoint()).isEqualTo(1);
	}

	@Test
	@DisplayName(("4 미만이면 이동안한다."))
	public void stopTest() {
		underTest.move(3);
		assertThat(underTest.getPoint()).isEqualTo(0);
	}

}
