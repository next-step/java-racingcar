package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.model.RacingCars;

class RacingCarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "       ", ", ,    , , , ", "SONATA,C CLASS"})
	@DisplayName("레이싱 복수 이름 예외 테스트")
	void createNameExceptionTest() {

		String carNames = "SONATA, ,";
		String[] names = carNames.split(",");

		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCars(names));
	}

	@ParameterizedTest
	@ValueSource(strings = {"M4", "코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("레이싱 복수 이름 추가 객체 생성 테스트")
	void createRacingCarsAddNameTest(String carNames) {

		String[] names = carNames.split(",");
		RacingCars cars = new RacingCars(names);

		assertThat(cars.getCars().size()).isEqualTo(names.length);
	}

	@Test
	@DisplayName("레이싱 복수 객체 생성 테스트")
	void createRacingCarsTest() {

		RacingCars cars = new RacingCars(5);

		assertThat(cars.getCars().size()).isEqualTo(5);
	}
}
