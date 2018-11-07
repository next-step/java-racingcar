package racing;

import org.junit.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


	@Test
	public void move_이동함() {
		Car car = new Car("popo", 0);
		car.move(4);
		Integer position = car.getPosition();
		assertThat(position).isEqualTo(1);
	}

	@Test
	public void move_이동안함() {
		Car car = new Car("popo", 0);
		car.move(3);
		Integer position = car.getPosition();
		assertThat(position).isEqualTo(0);
	}

	@Test
	public void isMaxPosition_최대_위치일때() {
		Car car = new Car("popo", 5);
		car.isMaxPosition(5);
	}

	@Test
	public void isMaxPosition_최대_위치가아닐때() {
		Car car = new Car("popo", 2);
		car.isMaxPosition(5);
	}
}