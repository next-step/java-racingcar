package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

	@Test
	@DisplayName("레이싱 복수 이름 예외 테스트")
	void createNameExceptionTest() {

		String carNames = "SONATA, ,";

		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCars(new CarNames(carNames)));
	}

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("레이싱 복수 이름 추가 객체 생성 테스트")
	void createRacingCarsAddNameTest(String carNames) {

		CarNames names = new CarNames(carNames);
		RacingCars cars = new RacingCars(names);

		// assertThat(cars).isEqualTo(new RacingCars(names));
	}
}
