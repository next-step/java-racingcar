package study.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("최대 입력 가능한 이름 글자 범위를 초과하면 예외를 던진다.")
	@Test
	void Given_CarNameOver5_Then_ThrowException() {
		Car car = new Car();
		assertThatThrownBy(() -> car.checkName("abcdefg")).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("Car 클래스의 위치의 초기값은 0이다.")
	@Test
	void Given_initPosition_Then_SetPositionToZero() {
		Car car = new Car();
		car.initPosition();
		assertThat(car.getPosition()).isEqualTo(0);
	}
}