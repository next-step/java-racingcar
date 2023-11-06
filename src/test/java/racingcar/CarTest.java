package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@ParameterizedTest
	@ValueSource(ints = {0,2})
	void 숫자가_4보다_작으면_움직이지_않는다(int num) {
		Car car = new Car(num);
		car.move(num);
		Assertions.assertThat(car.getLocation()).isEqualTo(num);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 7, 9})
	void 숫자가_4보다_크거나_같으면_1칸_전진한다(int num) {
		Car car = new Car(num);
		car.move(num);
		Assertions.assertThat(car.getLocation()).isEqualTo(num+1);
	}
}
