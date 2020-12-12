package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.racing.domain.game.cars.car.Car;
import edu.nextstep.racing.domain.game.cars.car.Location;

@DisplayName("Location : 자동차의 위치에 대한 원시값 포장 클래스")
class LocationTest {

	@DisplayName("move : 변수로 주어진 메소드의 실행 결과가 true이면 위치를 1 증가시킴.")
	@Test
	void move() {
		assertThat(new Location(2).move(Car.ALWAYS_MOVE_STRATEGY)).isEqualTo(new Location(3));
	}

	@DisplayName("compareTo : 인스턴스 변수 location에 따라 객체 대소 비교가 가능함.")
	@Test
	void compareTo() {
		assertThat(new Location(2)).isGreaterThan(new Location(1));
		assertThat(new Location(2)).isEqualByComparingTo(new Location(2));
		assertThat(new Location(2)).isLessThan(new Location(3));
	}

	@DisplayName("equals : 인스턴스 변수 location가 같으면 동일한 객체임.")
	@Test
	void testEquals() {
		assertThat(new Location(2)).isEqualTo(new Location(2));
	}

	@DisplayName("getValue : location을 원시값인 int형 그대로 리턴함.")
	@Test
	void getValue() {
		assertThat(new Location(2).getValue()).isEqualTo(2);
	}
}