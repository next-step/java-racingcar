package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@Test
	@DisplayName("자동차 이름 5자 초과하면 예외발생")
	void carNameOverFive() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름 5자 이하면 통과")
	void carNameBelowFive() {
		Car car = new Car("abcde");
		assertThat(car.getName()).isEqualTo(new Name("abcde"));
	}

	@ParameterizedTest
	@DisplayName("자동차 정지 검증")
	@ValueSource(ints = {1,2,3})
	void stopStatusOfRound(int input) {
		Car car = new Car("test");
		car.movingOfRound(input);
		assertThat(car.getStatus()).isEqualTo(new Position());
	}

	@ParameterizedTest
	@DisplayName("자동차 전진 검증")
	@ValueSource(ints = {4,5,6})
	void forwardStatusOfRound(int input) {
		Car car = new Car("test");
		car.movingOfRound(input);
		assertThat(car.getStatus()).isEqualTo(new Position(1));
	}
}
