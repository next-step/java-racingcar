package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

	@DisplayName("입력한 이름 갯수만큼 Cars가 생성되는지 확인")
	@ValueSource(strings = {"c1", "c1,c2,c3"})
	@ParameterizedTest
	public void when_giveCarsSize_expected_CreatedSameSize(String inputNames) {
		// given
		CarNames carNames = new CarNames(inputNames);
		RacingCars racingCars = RacingCars.of(carNames);

		// when
		boolean isSameSize = racingCars.isSameSize(carNames.values().size());

		// then
		assertThat(isSameSize).isTrue();
	}

}