package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarTest {
	@Test
	public void test_자동차_이동() {
		Car car = new Car();

		Assertions.assertThat(car.getPosition()).isEqualTo(0);

		car.moveForward();

		Assertions.assertThat(car.getPosition()).isEqualTo(1);
	}
}