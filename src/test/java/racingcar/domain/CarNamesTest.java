package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.DuplicateCarNameException;

class CarNamesTest {

	@DisplayName("자동차 이름 중복 시 DuplicateCarNameException 발생")
	@Test
	public void When_DuplicateCarNames_Expected_DuplicateCarNameException() {
		// given
		String inputNames = "test,test";
		// when, then
		assertThatThrownBy(() -> new CarNames(inputNames))
			.isInstanceOf(DuplicateCarNameException.class);
	}

	@DisplayName("자동차 이름 갯수만큼 Car 생성")
	@Test
	public void When_CarNames_Expected_SameSizeCarList() {
		// given
		CarNames carNames = new CarNames("test1,test2");
		Cars cars = Cars.of(carNames);

		// when
		boolean isSameSize = cars.isSameSize(carNames.values().size());

		// then
		assertThat(isSameSize).isTrue();
	}
}