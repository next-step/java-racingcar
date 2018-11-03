package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarTest {
	@Test
	public void test_자동차_이동_이동이_가능할_시() {
		Car car = new Car();

		Assertions.assertThat(car.getPosition()).isEqualTo(0);

		car.moveForward(()->true);

		Assertions.assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void test_자동차_이동_이동이_불가능할_시() {
		Car car = new Car();

		Assertions.assertThat(car.getPosition()).isEqualTo(0);

		car.moveForward(()->false);

		Assertions.assertThat(car.getPosition()).isEqualTo(0);
	}
}