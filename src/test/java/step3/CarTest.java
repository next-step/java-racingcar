package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	private Car car;

	@BeforeEach
	void init() {
		car = new Car();
	}

	@DisplayName(value = "자동차 전진 테스트")
	@Test
	void advance() {
		car.advance();
		int position = car.getPosition();
		assertThat(position).isEqualTo(1);
	}

	@DisplayName(value = "자동차 멈춤 테스트")
	@Test
	void stop() {
		car.stop();
		int position = car.getPosition();
		assertThat(position).isEqualTo(0);
	}
}
