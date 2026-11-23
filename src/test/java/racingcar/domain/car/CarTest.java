package racingcar.domain.car;

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
		Car car = new Car("pobi");
		car.go(number);
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	void 자동차는_생성직후_위치가_0이다() {
		Car car = new Car("pobi");
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void 자동차는_이름을_가진다() {
		Car car = new Car("pobi");
		assertThat(car.getName()).isEqualTo("pobi");
	}

	@Test
	void 자동차_이름이_빈문자열이_입력되면_예외를발생시킨다() {
		assertThatThrownBy(() -> new Car("", 3))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차는_이름과_위치를_생성자로_받는다() {
		Car car = new Car("pobi", 3);
		assertThat(car.getPosition()).isEqualTo(3);
	}

	@Test
	void 이름과_위치를_받을때_이름의_길이를_검증한다() {
		assertThatThrownBy(() -> new Car("pobiiii", 3))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 이름이_5자초과면_예외를_발생한다() {
		assertThatThrownBy(() -> new Car("pobiii"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차의_위치가_같으면_true를_반환한다() {
		Car car = new Car("pobi", 3);
		assertThat(car.isSamePosition(3)).isTrue();
	}

}
