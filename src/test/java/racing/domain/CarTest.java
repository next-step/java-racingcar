package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// 순서 보장 필요
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {

	private Car car = new Car();

	@Test
	@Order(1)
	@DisplayName("Car 오브젝트 초기 move 값 확인")
	void init() {
		assertThat(car.toString()).isEqualTo("");
	}

	@Test
	@Order(2)
	@DisplayName("Car 오브젝트 초기 move 값 확인 실패 케이스")
	void failInit() {
		assertThat(car.toString()).isNotEqualTo("-");
	}


	@Test
	@Order(3)
	@DisplayName("move() 메서드 호출 시 move 값 확인")
	void move() {
		car.move();
		assertThat(car.toString()).isEqualTo("-");
	}

	@Test
	@Order(4)
	@DisplayName("move() 메서드 호출 시 move 값 확인 실패 케이스")
	void failMove() {
		car.move();
		assertThat(car.toString()).isEqualTo("-");
	}
}