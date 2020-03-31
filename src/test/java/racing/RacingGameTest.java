package racing;

import org.junit.jupiter.api.Test;
import racing.domain.object.Car;
import racing.vo.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@Test
	void A_자동차_객체_생성_테스트() {
		// given
		final String name = "test";
		final int position = 3;
		// when
		Car car = new Car(name, position);
		// then
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getPosition()).isEqualTo(position);
	}

	@Test
	void B_자동차_이동_테스트() {
		// given
		final String name = "test";
		final Car car = new Car(name);
		// when
		car.move(1);
		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void C_최종_우승자_테스트() {
		// given
		final Car car1 = new Car("test1", 2);
		final Car car2 = new Car("test2", 5);
		final Car car3 = new Car("test3", 3);
		final Cars cars = new Cars(Arrays.asList(car1, car2, car3));
		// when
		final Cars winner = cars.getWinner();
		// then
		assertThat(winner).isEqualTo( new Cars(Arrays.asList(car2)) );
	}
}
