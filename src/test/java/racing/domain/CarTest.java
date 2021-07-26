package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class CarTest {

	private Car car;

	@BeforeEach
	void carInit() {
		car = new Car();
	}

	@Test
	@DisplayName("Car 오브젝트 초기 move 값 확인")
	void init() {
		assertThat(car.getMove()).isEqualTo(0);
	}

	@Test
	@DisplayName("Car 오브젝트 초기 move 값 확인 실패 케이스")
	void failInit() {
		assertThat(car.getMove()).isNotEqualTo(1);
	}


	@Test
	@DisplayName("move() 메서드 호출 시 randomValue가 4이상이면 move 값 증가")
	void move() {
		car.move(5);
		assertThat(car.getMove()).isEqualTo(1);
	}

	@Test
	@DisplayName("move() 메서드 호출 시 randomValue가 4이하면 move 값 그대로")
	void failMove() {
		car.move(3);
		assertThat(car.getMove()).isEqualTo(0);
	}
}