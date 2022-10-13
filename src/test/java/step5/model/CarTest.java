package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

	Car car;

	@BeforeEach
	void beforeEach(){
		car = new Car("hihi");
		car.move(() -> true);
	}

	@Test
	void 자동차_움직임_테스트() {
		Assertions.assertThat(car.getPosition()).isEqualTo(1);
	}
}