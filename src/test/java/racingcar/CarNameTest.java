package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.CarName;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {
	@Test
	@DisplayName("이름은 빈 값일 수 없다.")
	void whenNameIsBlankThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new CarName(""));
	}

	@Test
	@DisplayName("이름은 5자 이상일 수 없다.")
	void whenLengthIsOver5ThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new CarName("aaaaaa"));
	}
}
