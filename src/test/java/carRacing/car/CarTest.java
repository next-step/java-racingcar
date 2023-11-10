package carRacing.car;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.moveStrategy.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("random값이 4이상일 경우 한 칸 전진한다")
	@Test
	void moveCar() {
		Car car = new Car();
		MoveStrategy moveStrategy = () -> true;
		car.moveCar(moveStrategy);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("random값이 4미만일 경우 차는 그대로 서있는다")
	@Test
	void stopCar() {
		Car car = new Car();
		MoveStrategy moveStrategy = () -> false;
		car.moveCar(moveStrategy);

		assertThat(car.getPosition()).isEqualTo(0);
	}

	@DisplayName("자동차에 이름을 부여할 수 있다")
	@Test
	void giveNameCar() {
		Car car = new Car("pobi");

		assertThat(car.getName()).isEqualTo("pobi");
	}
}