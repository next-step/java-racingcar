package racing.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.car.exception.CarNameException;

public class NameTest {

	@DisplayName("이름 빈값 혹은 5자 초과")
	@ValueSource(strings = {"", "pobipo"})
	@ParameterizedTest
	void test1(String input) {
		assertThatThrownBy(() -> new Name(input))
			.isInstanceOf(CarNameException.class);
	}
}
