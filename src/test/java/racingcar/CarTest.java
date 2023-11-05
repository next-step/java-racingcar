package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@ParameterizedTest
	@ValueSource(ints = {1,2})
	void 차가_전진하면_위치가_1증가한다(int num) {
		Car car = new Car(num);
		car.moveForward();
		Assertions.assertThat(car.getLocation()).isEqualTo(num + 1);
	}
}
