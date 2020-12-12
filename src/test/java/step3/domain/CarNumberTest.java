package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNumberTest {

	@Test
	@DisplayName("입력된 carNumber만큰 Car 리스트를 생성한다.")
	void createCarsTest() {
		int number = 3;
		assertThat(new CarNumber(number).createCars()).hasSize(number);
	}

}