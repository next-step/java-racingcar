package carRacing.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carRacing.moveStrategy.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("움직이는 전략이 true일 때 한 칸 전진한다")
	@Test
	void moveCar() {
		Car car = new Car();
		MoveStrategy moveStrategy = () -> true;
		car.moveCar(moveStrategy);

		assertThat(car.isSamePosition(1)).isTrue();
	}

	@DisplayName("움직이는 전략이 false일 때 차는 그대로 서있는다")
	@Test
	void stopCar() {
		Car car = new Car();
		MoveStrategy moveStrategy = () -> false;
		car.moveCar(moveStrategy);

		assertThat(car.isSamePosition(1)).isFalse();
	}

	@DisplayName("자동차에 이름을 부여할 수 있다")
	@Test
	void giveNameCar() {
		Car car = new Car("pobi");

		assertThat(car.getName()).isEqualTo("pobi");
	}

	@DisplayName("자동차 이름이 5자 이상이면 예외를 발생한다")
	@Test
	void carNameLengthException() {
		assertThatThrownBy(() -> {
			new Car(0, "five5");
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("자동차 이름이 5자를 초과했습니다.");
	}
}