package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 생성")
	void create() {
		//given
		String name = "juu";

		//when
		Car car = new Car(new Name(name));

		//then
		assertThat(car).isEqualTo(new Car(new Name("juu")));
	}

	@Test
	@DisplayName("자동차 전진")
	void go() {
		//given
		Car car = new Car(new Name("pobi"));

		//when
		Car result = car.go(() -> true);

		//then
		assertThat(result.carPosition()).isEqualTo(1);

	}

	@Test
	@DisplayName("자동차 정지")
	void stop() {
		//given
		Car car = new Car(new Name("pobi"));

		//when
		Car result = car.go(() -> false);

		//then
		assertThat(result.carPosition()).isEqualTo(0);

	}
}