package racingcar;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
	@ParameterizedTest(name = "자동차 갯수 : {0}")
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("입력만큼 자동차의 갯수가 생성되고, 모든 자동차의 초기 위치는 0이다.")
	void initialCarAmountTest(int carAmount) {
		// when
		Cars cars = new Cars(carAmount);

		// then
		List<Integer> carsLocation = cars.getCarsLocation();
		Assertions.assertEquals(carAmount, carsLocation.size());
		Assertions.assertTrue(carsLocation.stream()
			.allMatch(location -> location == 0));
	}

}
