package study.step5.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.exception.BadRequestException;

class CarTest {

	@DisplayName("car 초기 생성시, 위치는 0으로 초기화된다.")
	@Test
	void Given_Car_Then_InitPositionToZero() {
		Car car = new Car("abcd");

		assertThat(car.getPosition()).isEqualTo(0);
	}

	@DisplayName("최대 입력 가능한 이름 글자 범위를 초과하면 예외를 던진다.")
	@Test
	void Given_NameOver5_Then_ThrowException() {
		assertThatThrownBy(() ->new Car("abcdef")).isInstanceOf(BadRequestException.class);
	}
}