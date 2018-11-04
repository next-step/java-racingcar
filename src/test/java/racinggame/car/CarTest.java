package racinggame.car;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarTest {
	@Test
	public void test_자동차_이동_이동이_가능할_시() {
		String carName = "test";
		Car actual = new Car(carName);

		assertThat(actual.getPosition()).isEqualTo(0);

		actual.moveForward((car) -> true);

		assertThat(actual.getPosition()).isEqualTo(1);
	}

	@Test
	public void test_자동차_이동_이동이_불가능할_시() {
		String carName = "test";
		Car actual = new Car(carName);

		assertThat(actual.getPosition()).isEqualTo(0);

		actual.moveForward((car) -> false);

		assertThat(actual.getPosition()).isEqualTo(0);
	}

	@Test
	public void test_자동차_생성_확인() {
		String carName = "test";
		Car actual = new Car(carName);
		assertThat(actual.getName()).isEqualTo(carName);
	}
}