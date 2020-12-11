package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "아이언맨슈트"})
	@DisplayName("CarName Exception 테스트")
	void initExceptionTest(String carName) {

		// Exception 조건은 3가지 (IllegalArgumentException)
		// 1. null
		// 2. 빈값 ("")
		// 3. 길이가 5 이상인 문자열
		assertThatIllegalArgumentException().isThrownBy(() -> new CarName(carName));
	}

	@Test
	@DisplayName("CarName Null Init Exception 테스트")
	void initNullExceptionTest() {

		assertThatIllegalArgumentException().isThrownBy(() -> new CarName(null));
	}

	@ParameterizedTest
	@ValueSource(strings = {"차", "탱크", "자동차", "레인지로버"})
	@DisplayName("CarName 생성 및 값 할당 테스트")
	void initCarNameTest(String carName) {

		CarName car = new CarName(carName);

		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(carName);
	}
}
