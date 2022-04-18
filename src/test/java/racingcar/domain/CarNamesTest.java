package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.DuplicateCarNameException;
import racingcar.view.InputView;

class CarNamesTest {

	@DisplayName("자동차 이름 중복 시 DuplicateCarNameException 발생")
	@Test
	public void When_DuplicateCarNames_Expected_DuplicateCarNameException() {
		// given
		String[] splitNames = "test,test".split(InputView.CAR_NAME_SPLIT_REGEX);

		// when, then
		assertThatThrownBy(() -> new CarNames(splitNames))
			.isInstanceOf(DuplicateCarNameException.class);
	}

	@DisplayName("자동차 이름 갯수만큼 Car 생성")
	@Test
	public void When_CarNames_Expected_SameSizeCarList() {
		// given
		String[] splitNames = "test1,test2".split(InputView.CAR_NAME_SPLIT_REGEX);
		CarNames carNames = new CarNames(splitNames);

		// when
		List<Car> cars = carNames.createCars();

		// then
		assertThat(splitNames.length).isEqualTo(cars.size());
	}
}