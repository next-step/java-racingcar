package racing.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.List;

class InputViewTest {

	@DisplayName("자동차 개수를 입력하면 개수만큼 자동차가 생성된다.")
	@Test
	void generateCars() {
		List<Car> cars = InputView.generateCars(3);
		Assertions.assertThat(cars).hasSize(3);
	}

}
