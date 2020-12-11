package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {

	@Test
	@DisplayName("CarNames NULL 객체 생성 테스트")
	void initNullTest() {
		// Exception 조건은 3가지 (IllegalArgumentException)
		// 1. null
		// 2. 빈값 ("") or 공백("   ")
		// 3. , 가 없는 문자열
		assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(null));    // null
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "CarNames 객체 벨리데이션 테스트 콤마 없는 문자열"})
	@DisplayName("CarNames 객체 벨리데이션 테스트")
	void validationCarNamesTest(String names) {

		// Exception 조건은 3가지 (IllegalArgumentException)
		// 1. null
		// 2. 빈값 ("") or 공백("   ")
		// 3. , 가 없는 문자열
		assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(names));   // 빈값
	}

	@Test
	@DisplayName("CarNames 객체 생성 테스트")
	void initCarNamesTest() {

		CarNames names = new CarNames("M6,i30,A6,G90,EQ900");

		assertThat(names).isNotNull();
	}
}
