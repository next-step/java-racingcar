package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

	@ParameterizedTest
	@CsvSource(
		value = {"3,0", "4,1"}
	)
	void 자동차는_숫자가_4이상이면_전진한다(int number, int expected) {
		Car car = new Car();
		car.go(number);
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	void 자동차는_생성직후_위치가_0이다() {
		Car car = new Car();
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void 자동차는_이름을_가진다() {
		Car car = new Car("pobi");
		assertThat(car.getName()).isEqualTo("pobi");
	}

}
