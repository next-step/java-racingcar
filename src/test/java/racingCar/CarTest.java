package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	@DisplayName("4이상 일때 전진 확인 테스트")
	void checkCarMoving() {
		car.move(Racing.move(4));
		assertThat(car.getStatus()).isEqualTo("-");
	}

	@Test
	@DisplayName("4이상 일때 정지 테스트")
	void checkCarMovingAndStopMoving() {
		car.move(Racing.move(3));
		assertThat(car.getStatus()).isEqualTo("");
	}

	@Test
	@DisplayName("자동차 이름 5자 초과하면 예외발생")
	void carNameOverFive() {
		assertThatThrownBy(() -> car.createName("abcdef"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름 5자 이하면 통과")
	void carNameBelowFive() {
		car.createName("abcde");
		assertThat(car.getName()).isEqualTo("abcde");
	}
}
