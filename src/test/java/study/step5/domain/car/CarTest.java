package study.step5.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.movestrategy.MoveStrategy;

class CarTest {
	MoveStrategy moveStrategy;

	@DisplayName("Car 클래스의 위치의 초기값은 0이다.")
	@Test
	void Given_initPosition_Then_SetPositionToZero() {

		assertThat(new Car("car").getPosition()).isEqualTo(0);
	}

	@DisplayName("car 의 움직임 전략이 true인 경우 car 의 위치가 1 증가한다.")
	@Test
	void Given_IsMovableTrue_Then_PositionGetPlus() {
		Car car = new Car("car");

		MoveStrategy moveStrategy = () -> true;

		car.move(moveStrategy);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("car 의 움직임 전략이 false인 경우 car 의 위치는 변하지 않는다.")
	@Test
	void Given_IsMovableFalse_Then_PositionSame() {
		Car car = new Car("car");

		MoveStrategy moveStrategy = () -> false;

		car.move(moveStrategy);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}