package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarTest {
	@Test
	public void test_자동차_이동_이동이_가능할_시() {
		Car actual = new Car();

		Assertions.assertThat(actual.getPosition()).isEqualTo(0);

		actual.moveForward((car)->true);

		Assertions.assertThat(actual.getPosition()).isEqualTo(1);
	}

	@Test
	public void test_자동차_이동_이동이_불가능할_시() {
		Car actual = new Car();

		Assertions.assertThat(actual.getPosition()).isEqualTo(0);

		actual.moveForward((car)->false);

		Assertions.assertThat(actual.getPosition()).isEqualTo(0);
	}
}