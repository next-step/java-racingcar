package study3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	Car car;

	@Test
	@DisplayName("움직임 테스트")
	public void moveTest() {
		car = new Car();
		int result = car.move(2);
		assertThat(result).isNotEqualTo(1);
	}

}
