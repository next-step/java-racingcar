package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

	@ParameterizedTest(name = "자동차 이름 : {0}, 자동차 갯수 : {1}")
	@CsvSource(value = {
		"pobi,crong,honux|3",
		"aaa, bbbb|2"
	}, delimiter = '|')
	@DisplayName("입력만큼 자동차의 갯수가 생성되고, 모든 자동차의 초기 위치는 0이다.")
	void initialCarAmountTest(String carsName, int carAmount) {
		// when
		String[] names = carsName.split(",");
		Cars cars = new Cars(carsName);

		// then
		List<CarInfo> carInfos = cars.getCarsNameAndLocation();
		assertThat(carInfos.size()).isEqualTo(carAmount);
		for (int i = 0; i < names.length; i++) {
			assertThat(carInfos.get(i)
				.name()).isEqualTo(names[i].trim());
			assertThat(carInfos.get(i)
				.location()).isZero();
		}
	}

	@Test
	@DisplayName("가장 멀리 간 자동차의 위치를 반환한다.")
	void findMaxLocationTest() {
		// given
		Cars cars = new Cars("pobi,crong,honux");
		cars.moveCars(() -> true);

		// when
		int maxLocation = cars.findMaxLocation();

		// then
		assertThat(maxLocation).isEqualTo(1);
	}

	@Test
	@DisplayName("가장 멀리 간 사람이 우승자가 된다.")
	void determineWinnerTest() {
		// given
		Cars cars = new Cars("pobi,crong,honux");
		cars.moveCars(() -> true);
		cars.moveCars(() -> false);
		cars.moveCars(() -> true);

		// when
		List<String> winners = cars.determineWinner();

		// then
		assertThat(winners).contains("pobi", "crong", "honux");
	}

}
