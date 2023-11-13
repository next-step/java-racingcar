package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;

public class CarTest {

	@ParameterizedTest
	@ValueSource(strings = {"cjsrhd94", "123456"})
	void 차량의_이름이_5글자를_초과하면_IllegalArgumentsException을_던진다(String name) {
		assertThatThrownBy(() -> new Car(name, 0))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {0,2})
	void 숫자가_4보다_작으면_움직이지_않는다(int num) {
		Car car = new Car("test",0);
		car.move(num);
		Assertions.assertThat(car.getLocation()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 7, 9})
	void 숫자가_4보다_크거나_같으면_1칸_전진한다(int num) {
		Car car = new Car("test",0);
		car.move(num);
		Assertions.assertThat(car.getLocation()).isEqualTo(1);
	}
}
