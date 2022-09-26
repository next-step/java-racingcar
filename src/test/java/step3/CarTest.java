package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	@DisplayName("4이상 일때 전진 확인 테스트")
	void checkCarMoving() {
		Car car = new Car();
		String actual = Racing.move(4);
		assertThat(car.move(actual)).isEqualTo("-");
	}
}
