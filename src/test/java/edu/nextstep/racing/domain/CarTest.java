package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car : 자동차 이름, 위치, 이동전략 등을 가지고 있으며, 이를 이용해 이동을 하고 자동차끼리 대소비교 가능.")
class CarTest {

	@DisplayName("move : 자동차의 이동을 시도할 수 있음. 시도가 성공하면 자동차의 위치가 1 증가함.")
	@Test
	void move() {
		Car car = new Car("pobi", 2, Car.ALWAYS_MOVE_STRATEGY);
		car.move();
		assertThat(car.getLocation()).isEqualTo(new Location(3));
	}

	@DisplayName("compareTo : 자동차끼리 현재 위치를 기준으로 서로 대소를 비교할 수 있음.")
	@Test
	void compareTo() {
		assertThat(new Car("name", 2)).isGreaterThan(new Car("name", 1));
		assertThat(new Car("name", 2)).isEqualByComparingTo(new Car("name", 2));
		assertThat(new Car("name", 2)).isLessThan(new Car("name", 3));
	}
}