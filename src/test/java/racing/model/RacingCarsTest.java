package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("레이싱 복수 이름 추가 객체 생성 테스트")
	void createRacingCarsAddNameTest(CarNames carNames) {

		assertThat(new RacingCars(carNames)).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"코브라", "520i,  ", "M6,i30,A6,G90,EQ9000"})
	@DisplayName("레이싱 차랑명 예외 테스트")
	void initExceptionTest(String carNames) {

		// Exception 조건은 4가지 (IllegalArgumentException)
		// 1. null
		// 2. 빈값 ("") or 공백("   ")
		// 3. , 가 없는 문자열
		// 4. 길이가 5 이상인 문자열
		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCars(new CarNames(carNames)));
	}
}
