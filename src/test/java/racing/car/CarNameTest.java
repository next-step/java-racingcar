package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings = {"hi", "oh", "peter"})
	@DisplayName("CarName.toString() 테스트")
	void CarName_toString(String name) {
		CarName carName = new CarName(name);
		assertThat(carName.toString()).isEqualTo(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"A", "hi", "peter"})
	@DisplayName("CarName 의 validation 테스트, 무조건 성공해야함")
	void validation_noThrows(String name) {
		CarName.validation(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "longggg"})
	@DisplayName("CarName 의 validation 테스트, 실패해야함")
	void validation_expectedException(String name) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> CarName.validation(name));
	}
}
